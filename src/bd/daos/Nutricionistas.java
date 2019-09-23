package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Nutricionistas {
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
	
	public static void incluir(Nutricionista nutri) throws Exception
	{
		if(nutri == null)
			throw new Exception("Valores não fornecidos");
		if(Nutricionistas.cadastrado(nutri.getCodigo()))
			throw new Exception("Nutricionista já cadastrado");
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
	
	public static void alterar(Nutricionista nutri) throws Exception
	{
		if(nutri == null)
			throw new Exception("Preencha todos os espaços");
		
		try 
		{
			String sql;
			sql = "UPDATE Nutricionista "
					+ "SET Nome = ?"
					+ "SET Cpf = ?"
					+ "SET Email = ?"
					+ "SET Telefone = ?"
					+ "SET Senha = ?"
					+ "where codNutricionista = ?"; 
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
