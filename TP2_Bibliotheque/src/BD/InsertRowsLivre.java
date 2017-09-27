package BD;

import java.sql.*;

public class InsertRowsLivre {
	
	
	public static void insertRowsLivre() {
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
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0199232765', true, 3003, 101, 5001)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0486437965', true, 3003, 101, 5002)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0486415864', false, 3002, 101, 5003)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0099589341', false, 3002, 101, 5004)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0486272788', true, 3002, 101, 5005)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0486275574', false, 3002, 101, 5006)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0199535583', false, 3003, 101, 5007)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0307356543', false, 3001 , 101, 5008)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0261102354', false, 3001, 101, 5009)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0261102361', false, 3001, 101, 5010)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0261102378', false, 3001, 101, 5011)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0141036144', false, 3002, 101, 5012)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0141036137', false, 3002, 101, 5013)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-2081266445', false, 3004, 102, 5014)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0393347098', false, 3002, 101, 5015)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-2070643073', false, 3004, 102, 5016)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-0156013987', false, 3004, 102, 5017)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-2070518425', false, 3004, 102, 5018)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-2268033945', false, 3004, 102, 5019)");
			
			stmt.executeUpdate(
					"INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " +
					"VALUES ('978-2848762142', false, 3005, 102, 5020)");

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
