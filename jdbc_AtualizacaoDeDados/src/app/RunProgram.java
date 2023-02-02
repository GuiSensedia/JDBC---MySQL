package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class RunProgram {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			//Iniciando conexão com o banco de Dados;
			conn = DB.getConnection();
			// Comando para atualização do banco de Dados;
			st = conn.prepareStatement(
					"UPDATE seller " // UPTADE - Comando de atualização
					+ "SET BaseSalary = BaseSalary + ? " // SET - Comando de mudança
					+ "WHERE" // WHERE - Indicando uma condição ou Restrição da atualização
					+ "(DepartmentId = ?)" // Argumento de restrição.
					);
					st.setDouble(1, 200.0);
					st.setInt(2, 2);
					
					int rowsAffected = st.executeUpdate();
					System.out.println("rows affected = " + rowsAffected);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
	}
}
