package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Dietas {
	public static boolean cadastrado(int codUsuario) throws Exception
	{
		boolean retorno = false;
		try 
		{
			String sql;
			sql = "select * from Dieta where codUsuario = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setInt(1,codUsuario);
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
			retorno = resultado.first();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao procurar dieta");
		}
		
		return retorno;
	}
	
	public static void inserir(String codUsuario, String dieta, String dia) throws Exception
	{
		if(dieta.length() > 500)
			throw new Exception("Digite uma dieta com menos de 500 caracteres");
		
		try 
		{
			String sql;
			sql = "UPDATE Nutricionista "
					+ "SET "+ dia +" = ?"
					+ "where codUsuario = ?"; 
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, dieta);
			BDSQLServer.COMANDO.setString(2, codUsuario);

			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar os dados");
		}
	}
}
