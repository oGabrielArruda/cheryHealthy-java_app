package bd.daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Usuarios {
	/**
	 * Verifica se o usuário está cadastrado.
	 * É passado um código como parâmetro, e uma busca é realizada a partir desse código
	 * se existr um usuário com esse código, retorna true, se não retorna false
	 * @param codigo do usuário a ser verificado
	 * @return retorna true se o usuário estiver cadastrado
	 * @throws Exception em caso de problemas com conexão ao banco de dados.
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
	 * Altera o usuário.
	 * É passado um objeto da classe Usuário como parâmetro
	 * Assim, é realizado um update na tabela sql, com os novos atributos do usuário que manterá seu código
	 * @param user Usuário a ser editado
	 * @throws Exception se o user for null, ou se ocorrer problemas de conexão
	 */
	public static void alterar(Usuario user) throws Exception
	{
		if(user == null)
			throw new Exception("Preencha todos os espaços");
		
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
	 * Recupera os valores de deterimando usuário.
	 * É passado um código como parâmetro
	 * Executa-se um select no banco de dados que retorna os valores do usuário selecionado
	 * Caso o usuário não exista, é lançada exceção
	 * Então, instancia-se um novo usuário de acordo com os valores selecionados
	 * Por fim, esse usuário é retornado
	 * @param codigo código do usuário a ser pegado
	 * @return o usuário pertencente ao código
	 * @throws Exception se o código não existir ou se ocorrer problemas com o banco de dados
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
					resultado.getInt("pontuação"));
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar usuário");
		}
		return user;
	}
	
	/**
	 * Recupera todos os usuários cadastrados pertencentes à determinado nutricionista.
	 * É instanciada uma lista do objeto Usuário.
	 * Em seguida, é feito um select no banco de dados.
	 * O select, recupera o valor de todos usuários pertencentes ao nutricionista que teve seu código passado como parâmetro.
	 * Os dados do select são percorridos, e para cada valor, é instanciado um novo usuário.
	 * O usuário instanciado é adicionado à lista.
	 * Por fim, a lista é retornada.
	 * @param codNutri código do nutricionista que terá seus usuários selecionados
	 * @return uma lista com todos usuários pertencentes ao nutricionista
	 * @throws Exception em caso de erro de conexão com o Banco de Dados.
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
								   resultado.getInt("Pontuação"));
				ret.add(user);
			}
		}
		catch(Exception ex)
		{
			throw new Exception("Erro ao procurar usuários");
		}
		
		return ret;
	}
}
