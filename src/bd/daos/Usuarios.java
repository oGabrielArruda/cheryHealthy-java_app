package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Usuarios {
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
			BDSQLServer.COMANDO.setInt(7, user.getAltura());
			BDSQLServer.COMANDO.setInt(7, user.getPontuacao());
			BDSQLServer.COMANDO.setInt(7, user.getCodNutricionista());
			
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar os dados");
		}
	}
	
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
					resultado.getDouble("peso"),
					resultado.getInt("altura"),
					resultado.getInt("codNutricionista"),
					resultado.getInt("pontuacao"));
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar usuário");
		}
		return user;
	}
}
