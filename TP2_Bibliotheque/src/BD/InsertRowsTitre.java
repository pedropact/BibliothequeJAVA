package BD;

import java.sql.*;

public class InsertRowsTitre {
	

	public static void insertRowsTitre() {
		
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
			// INSERT TABLE TITRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4001, 'War and Peace')");

			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4002, 'Anna Karenina')");

			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4003, 'Great Expectations')");

			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4004, 'Sense and Sensibility')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4005, 'Hamlet')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4006, 'Romeo and Juliet')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4007, 'The Flowers of Evil')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4008, 'Brave New World')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4009, 'The Lord of the Rings - The Fellowship of the Ring')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4010, 'The Lord of the Rings - The Two Towers')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4011, 'The Lord of the Rings - The Return of the King')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4012, '1984')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4013, 'Animal Farm')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4014, 'Le Procès')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4015, 'Metamorphosis')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4016, 'Harry Potter - Et le prince de sang-mêlé')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4017, 'Le Petit Prince')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4018, 'Harry Potter - À L école des Sorciers')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4019, 'Le Mystère du Grand Sphinx')");
			
			stmt.executeUpdate(
					"INSERT INTO titre (id_titre, titre) " +
					"VALUES (4020, 'Amérique, années Obama : Chroniques d un pays ingouvernable')");

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
