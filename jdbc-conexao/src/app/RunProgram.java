package app;

import java.sql.Connection;

import db.DB;

public class RunProgram {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		
		DB.closeConnection();

	}
}
