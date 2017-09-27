package BD;

import java.sql.*;

public class InsertRowsAuteur {


	public static void insertRowsAuteur() {
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
			// INSERT TABLE AUTEUR
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1001, 'Leo Tolstoy')");

			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1002, 'Charles Dickens')");

			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1003, 'Jane Austen')");

			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1004, 'William Shakespeare')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1005, 'Charles Baudelaire')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1006, 'J.K. Rowling')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1007, 'J. R. R. Tolkien')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1008, 'Aldous Huxley')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1009, 'George Orwell')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1010, 'Vladmir Nabokov')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1011, 'Franz Kafka')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1012, 'Antoine de Saint-Exupery')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1013, 'Robert Bauval')");
			
			stmt.executeUpdate(
					"INSERT INTO auteur (id_auteur, auteur) " +
					"VALUES (1014, 'Corine Lesnes')");

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
