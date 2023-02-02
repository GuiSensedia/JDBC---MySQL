package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class RunProgram {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM department " //Comando SQL para deletar um dado.
					+ "WHERE " //Restrição do comando;
					+ "(Id = ?) "
					);
			
			st.setInt(1, 7);
			
			
		int rowsAffected = st.executeUpdate();
		System.out.println("Done! rows affected is : " + rowsAffected);
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
	}
}
