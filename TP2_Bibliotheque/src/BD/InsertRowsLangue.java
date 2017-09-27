package BD;

import java.sql.*;

public class InsertRowsLangue {
	

	public static void insertRowsLangue() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			//====================================

			con.setAutoCommit(false);

			Statement stmt;

			//====================================
			// INSERT TABLE LANGUE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO langue (id_langue, langue) " +
					"VALUES (101, 'English')");

			stmt.executeUpdate(
					"INSERT INTO langue (id_langue, langue) " +
					"VALUES (102, 'Français')");


			stmt.close();
			con.commit();

			//====================================
			con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
