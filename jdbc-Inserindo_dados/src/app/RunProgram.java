package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import db.DB;

public class RunProgram {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn	= null;
		PreparedStatement st = null;
		try {
		//Iniciando a conexão com o banco de dados;
		conn = DB.getConnection();
		//String de inserção de dados no banco;
		st = conn.prepareStatement(
				"INSERT INTO seller" //MySQL - código de inserção + o local;
				+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)" 
				+ " VALUES" //MySQL - Os valores que serão adicionados;
				+ "(?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		
		//Para adicionar valores valores, utilizamos a referência "st", mais o metodo set, seguido do tipo de dado;
		//O primeiro dado é a localização em que o dado será inserido (Seguindo os pontos de interrogação e o tipo de dado passados no método prepareStatement;
		
		st.setString(1, "Clara Maria");
		st.setString(2, "clara.maria@gmail.com");
		st.setDate(3, new java.sql.Date(sdf.parse("24/04/2000").getTime()));
		st.setDouble(4, 3000);
		st.setInt(5, 4);
		
		int rowsAffected = st.executeUpdate();// Função para executar a alteração de dados; O resultado dessa fução retorna um número inteiro, que é a quantidade de linhas alteradas.
		System.out.println("Done! Rows Affected = " + rowsAffected);
		
		if (rowsAffected > 0) {
			ResultSet rs = st.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				System.out.println("Done! Id " + id + "succeful.");
			}
		} else {
			System.out.println("No row affected!");
		}
		}
		catch(SQLException e) {
			e.getMessage();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	
	
	
	}
}
