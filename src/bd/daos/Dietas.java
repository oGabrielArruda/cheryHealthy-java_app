package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Dietas {
	/**
	 Método que insere a dieta na tabela.
	 Insere o texto digitado no campo de determinado dia de determinado usuário
	 * @param codUsuario o código do usuário que terá sua dieta alterada
	 * @param dieta a string que será inserida no banco
	 * @param dia a string que representa o dia da semana que a dieta será válida
	 * @throws Exception se ocorrer algum erro na inserção
	 */
	public static void inserir(int codUsuario, String dieta, String dia) throws Exception
	{
		if(dieta.length() > 300)
			throw new Exception("Digite uma dieta com menos de 300 caracteres");
		
		try 
		{
			String sql;
			sql = "update dieta set "+ dia + " = ? where codUsuario = ?";
			BDSQLServer.COMANDO.prepareStatement(sql);
			BDSQLServer.COMANDO.setString(1, dieta);
			BDSQLServer.COMANDO.setInt(2, codUsuario);

			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(Exception ex) 
		{
			throw new Exception("Erro ao alterar os dados");
		}
	}
}
