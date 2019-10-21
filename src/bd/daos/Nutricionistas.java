package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Nutricionistas {
	/**
	 M�todo que confere se o nutricionista est� cadastrado
	 * @param codigo � o c�digo do usu�rio que ser� procurado
	 * @return se o usu�rio est� cadastrado
	 * @throws Exception se ocorrer algum erro na procura
	 */
	public static boolean cadastrado(int codigo) throws Exception
	{
		boolean retorno = false;
		try 
		{
			String sql;
			sql = "select * from Nutricionista where codNutricionista = ?";
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
	 M�todo que inclui um novo nutricionista
	 * @param nutri objeto da classe Nutricionista que ser� incluido
	 * @throws Exception se o objeto dado for inv�lidos
	 */
	public static void incluir(Nutricionista nutri) throws Exception
	{
		if(nutri == null)
			throw new Exception("Valores n�o fornecidos");
		if(Nutricionistas.cadastrado(nutri.getCodigo()))
			throw new Exception("Nutricionista j� cadastrado");
		try 
		{
			String sql;
			sql = "insert into Nutricionista values(?, ?, ?, ?, ?, ?)";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, nutri.getCodigo());
			BDSQLServer.COMANDO.setString(2, nutri.getNome());
			BDSQLServer.COMANDO.setString(3, nutri.getCpf());
			BDSQLServer.COMANDO.setString(4, nutri.getEmail());
			BDSQLServer.COMANDO.setString(5, nutri.getTelefone());
			BDSQLServer.COMANDO.setString(6, nutri.getSenha());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao cadastrar/ Verifique todos os campos");
		}
	}
	
	/**
	 M�todo que altera as informa��es de um nutricionista j� inserido
	 * @param nutri objeto da classe nutricionsta que ser� alterado
	 * @throws Exception se o objeto for inv�lido ou se ocorrer erros na conex�o
	 */
	public static void alterar(Nutricionista nutri) throws Exception
	{
		if(nutri == null)
			throw new Exception("Preencha todos os espa�os");
		
		try 
		{
			String sql;
			sql = "update Nutricionista set nome= ?, cpf = ?, email = ?, telefone = ?, senha = ? where codNutricionista = ?";

			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, nutri.getNome());
			BDSQLServer.COMANDO.setString(2, nutri.getCpf());
			BDSQLServer.COMANDO.setString(3, nutri.getEmail());
			BDSQLServer.COMANDO.setString(4, nutri.getTelefone());
			BDSQLServer.COMANDO.setString(5, nutri.getSenha());
			BDSQLServer.COMANDO.setInt(6, nutri.getCodigo());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar os dados");
		}
	}
	
	/**
	 M�todo que retorna um nutricionista.
	 * @param codigo � o c�digo do nutricionista a ser retornado
	 * @return o objeto do nutricionista do respectivo c�digo
	 * @throws Exception se o nutricionista n�o estiver cadastrado, ou problemas no bd
	 */
	public static Nutricionista getNutricionista(int codigo) throws Exception 
	{
		Nutricionista nutri = null;
		try 
		{
			String sql = "select * from Nutricionista where codNutricionista = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1, codigo);
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			if(!resultado.first())
				throw new Exception("Nao cadastrado");
			
			nutri = new Nutricionista(codigo, 
					resultado.getString("Nome"), 
					resultado.getString("Cpf"),
					resultado.getString("Email"),
					resultado.getString("telefone"),
					resultado.getString("senha"));
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar nutricionista");
		}
		return nutri;
	}
}
