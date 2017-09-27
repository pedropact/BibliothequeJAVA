package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRowsLivreTitreAuteur {


	public static void insertRowsLivreTitreAuteur() {
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
			// INSERT TABLE LIVRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5001, 4001, 1001, 2001)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5002, 4002, 1001, 2007)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5003, 4003, 1002, 2001)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5004, 4004, 1003, 2007)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5005, 4005, 1004, 2001)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5006, 4006, 1004, 2007)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5007, 4007, 1005, 2004)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5008, 4008, 1008, 2008)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5009, 4009, 1007, 2003)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5010, 4010, 1007, 2003)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5011, 4011, 1007, 2003)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5012, 4012, 1009, 2008)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5013, 4013, 1009, 2001)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5014, 4014, 1011, 2002)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5015, 4015, 1011, 2002)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5016, 4016, 1006, 2006)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5017, 4017, 1012, 2006)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5018, 4018, 1006, 2006)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5019, 4019, 1013, 2009)");
			
			stmt.executeUpdate(
					"INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " +
					"VALUES (5020, 4020, 1013, 2009)");


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
