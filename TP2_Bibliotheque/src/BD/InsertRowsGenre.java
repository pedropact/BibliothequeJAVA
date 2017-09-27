package BD;

import java.sql.*;

public class InsertRowsGenre {


	public static void insertRowsGenre() {
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
			// INSERT TABLE GENRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2001, 'Littérature')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2002, 'Fiction')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2003, 'Fantasie')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2004, 'Phoème')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2005, 'Histoire')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2006, 'Jeunesse')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2007, 'Roman')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2008, 'Science-fiction')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2009, 'Histoire')");

			stmt.executeUpdate(
					"INSERT INTO genre (id_genre, genre) " +
					"VALUES (2010, 'Politique')");


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