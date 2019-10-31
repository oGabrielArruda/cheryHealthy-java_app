package bd.daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Usuarios {
	/**
	 * Verifica se o usu�rio est� cadastrado.
	 * � passado um c�digo como par�metro, e uma busca � realizada a partir desse c�digo
	 * se existr um usu�rio com esse c�digo, retorna true, se n�o retorna false
	 * @param codigo do usu�rio a ser verificado
	 * @return retorna true se o usu�rio estiver cadastrado
	 * @throws Exception em caso de problemas com conex�o ao banco de dados.
	 */
	public static boolean cadastrado(int codigo) throws Exception
	{
		boolean retorno = false;
		try 
		{
			String sql;
			sql = "select * from Usuario where codUsuario = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1,codigo);
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
			retorno = resultado.first();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar nutricionista");
		}
		
		return retorno;
	}
	
	
	/**
	 * Altera o usu�rio.
	 * � passado um objeto da classe Usu�rio como par�metro
	 * Assim, � realizado um update na tabela sql, com os novos atributos do usu�rio que manter� seu c�digo
	 * @param user Usu�rio a ser editado
	 * @throws Exception se o user for null, ou se ocorrer problemas de conex�o
	 */
	public static void alterar(Usuario user) throws Exception
	{
		if(user == null)
			throw new Exception("Preencha todos os espa�os");
		
		try 
		{
			String sql;
			sql = "UPDATE Usuario "
					+ "SET Nome = ?"
					+ "SET Cpf = ?"
					+ "SET Email = ?"
					+ "SET Telefone = ?"
					+ "SET Senha = ?"
					+ "SET peso = ?"
					+ "SET altura = ?"
					+ "SET pontuacao = ?"
					+ "where codNutricionista = ?"; 
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, user.getNome());
			BDSQLServer.COMANDO.setString(2, user.getCpf());
			BDSQLServer.COMANDO.setString(3, user.getEmail());
			BDSQLServer.COMANDO.setString(4, user.getTelefone());
			BDSQLServer.COMANDO.setString(5, user.getSenha());
			BDSQLServer.COMANDO.setDouble(6, user.getPeso());
			BDSQLServer.COMANDO.setDouble(7, user.getAltura());
			BDSQLServer.COMANDO.setInt(8, user.getPontuacao());
			BDSQLServer.COMANDO.setInt(9, user.getCodNutricionista());
			
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar os dados");
		}
	}
	
	/**
	 * Recupera os valores de deterimando usu�rio.
	 * � passado um c�digo como par�metro
	 * Executa-se um select no banco de dados que retorna os valores do usu�rio selecionado
	 * Caso o usu�rio n�o exista, � lan�ada exce��o
	 * Ent�o, instancia-se um novo usu�rio de acordo com os valores selecionados
	 * Por fim, esse usu�rio � retornado
	 * @param codigo c�digo do usu�rio a ser pegado
	 * @return o usu�rio pertencente ao c�digo
	 * @throws Exception se o c�digo n�o existir ou se ocorrer problemas com o banco de dados
	 */
	public static Usuario getUsuario(int codigo) throws Exception 
	{
		Usuario user = null;
		try 
		{
			String sql = "select * from Usuario where codUsuario = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codigo);
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			if(!resultado.first())
				throw new Exception("Nao cadastrado");
			
			user = new Usuario(codigo, 
					resultado.getString("Nome"), 
					resultado.getString("Cpf"),
					resultado.getString("Email"),
					resultado.getString("telefone"),
					resultado.getString("senha"),
					resultado.getFloat("peso"),
					resultado.getFloat("altura"),
					resultado.getInt("codNutricionista"),
					resultado.getInt("pontua��o"));
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar usu�rio");
		}
		return user;
	}
	
	/**
	 * Recupera todos os usu�rios cadastrados pertencentes � determinado nutricionista.
	 * � instanciada uma lista do objeto Usu�rio.
	 * Em seguida, � feito um select no banco de dados.
	 * O select, recupera o valor de todos usu�rios pertencentes ao nutricionista que teve seu c�digo passado como par�metro.
	 * Os dados do select s�o percorridos, e para cada valor, � instanciado um novo usu�rio.
	 * O usu�rio instanciado � adicionado � lista.
	 * Por fim, a lista � retornada.
	 * @param codNutri c�digo do nutricionista que ter� seus usu�rios selecionados
	 * @return uma lista com todos usu�rios pertencentes ao nutricionista
	 * @throws Exception em caso de erro de conex�o com o Banco de Dados.
	 */
	public static List<Usuario> selecionarUsuarios(int codNutri) throws Exception
	{
		List<Usuario> ret = new ArrayList<Usuario>();
		Usuario user;
		
		try 
		{
			String sql = "select * from Usuario where codNutricionista = ? order by nome";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codNutri);
			
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			
			while(resultado.next()) 
			{
				System.out.println("Cod" + codNutri);
				user = new Usuario(resultado.getInt("codUsuario"),
								   resultado.getString("nome"),
								   resultado.getString("cpf"),
								   resultado.getString("email"),
								   resultado.getString("telefone"),
								   resultado.getString("senha"),
								   resultado.getFloat("peso"),
								   resultado.getFloat("altura"),
								   resultado.getInt("codNutricionista"),
								   resultado.getInt("Pontua��o"));
				ret.add(user);
			}
		}
		catch(Exception ex)
		{
			throw new Exception("Erro ao procurar usu�rios");
		}
		
		return ret;
	}
}
