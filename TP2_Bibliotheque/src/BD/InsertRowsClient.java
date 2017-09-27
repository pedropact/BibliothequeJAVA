package BD;

import java.sql.*;

public class InsertRowsClient {


	public static void insertRowsClient() {
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
			// INSERT TABLE CLIENT
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES (20170001, 'Diana', 'Soares', '111 Berri', '514-438-0001', 'dsoares@email.com', '1990-06-27')");

			stmt.executeUpdate(
					"INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES (20170002, 'Pedro', 'Alves', '222 Parc', '514-438-0002', 'palves@email.com', '1979-03-26')");

			stmt.executeUpdate(
					"INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES (20170003, 'Patricia', 'Shimizu', '333 Laurier', '514-438-0003', 'pshimizu@email.com', '1980-11-07')");

			stmt.executeUpdate(
					"INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES (20170004, 'Rian', 'Santos', '444 St Laurent', '514-438-0004', 'rsantos@email.com', '1989-04-07')");

			stmt.executeUpdate(
					"INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES (20170005, 'Leila', 'Wagner', '555 Papineau', '514-438-0005', 'lwagner@email.com', '1982-06-16')");

			stmt.executeUpdate(
					"INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES (20170006, 'Simon', 'Bellemare', '666 Fairmount', '514-438-0006', 'sbellemare@email.com', '1980-12-26')");

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
