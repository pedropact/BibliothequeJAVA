package BD;

import java.sql.*;

public class InsertRowsEditeur {


	public static void insertRowsEditeur() {
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
			// INSERT TABLE EDITEUR
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO editeur (id_editeur, editeur) " +
					"VALUES (3001, 'HarperCollins')");

			stmt.executeUpdate(
					"INSERT INTO editeur (id_editeur, editeur) " +
					"VALUES (3002, 'Penguin')");

			stmt.executeUpdate(
					"INSERT INTO editeur (id_editeur, editeur) " +
					"VALUES (3003, 'Macmillan Publishers')");

			stmt.executeUpdate(
					"INSERT INTO editeur (id_editeur, editeur) " +
					"VALUES (3004, 'Du Rocher')");

			stmt.executeUpdate(
					"INSERT INTO editeur (id_editeur, editeur) " +
					"VALUES (3005, 'Philippe Rey')");


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
