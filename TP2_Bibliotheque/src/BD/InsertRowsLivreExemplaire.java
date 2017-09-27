package BD;

import java.sql.*;

public class InsertRowsLivreExemplaire {
	

	public static void insertRowsLivreExemplaire() {
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
			// INSERT TABLE LIVRE_EXEMPLAIRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0199232765/001', '1990-12-01', 'H 01 - 402 R', '978-0199232765')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0486437965/001', '1920-02-02', 'H 22 - 230 C', '978-0486437965')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0486415864/001', '2000-12-04', 'H 23 - 302 R', '978-0486415864')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0099589341/001', '1998-01-30', 'H 02 - 22 C', '978-0099589341')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0099589341/002', '1996-12-12', 'H 02 - 23 C', '978-0099589341')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0486272788/001', '1989-01-04', 'J 26 - 405 C', '978-0486272788')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0486275574/001', '2001-06-24', 'J 03 - 105 R', '978-0486275574')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0199535583/001', '2007-06-09', 'J 26 - 405 C', '978-0199535583')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0307356543/001', '2010-03-29', 'J 20 - 200 R', '978-0307356543')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0261102354/001', '2001-09-15', 'J 26 - 105 C', '978-0261102354')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0261102354/002', '2005-02-17', 'J 26 - 106 C', '978-0261102354')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0261102361/001', '2012-10-24', 'J 26 - 405 C', '978-0261102361')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0261102378/001', '2000-03-06', 'J 26 - 405 C', '978-0261102378')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0141036144/001', '2015-03-20', 'H 02 - 23 C', '978-0141036144')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0141036137/001', '2009-04-08', 'H 32 - 223 R', '978-0141036137')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0141036137/002', '2012-08-02', 'H 32 - 224 R', '978-0141036137')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2081266445/001', '1999-05-07', 'H 07 - 102 C', '978-2081266445')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0393347098/001', '2014-10-01', 'J 56 - 405 C', '978-0393347098')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0393347098/002', '2015-10-11', 'J 06 -  007 R', '978-0393347098')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2070643073/001', '2009-02-08', 'J 20 - 77 R', '978-2070643073')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-0156013987/001', '2006-10-24', 'J 16 - 05 C', '978-0156013987')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2070518425/001', '2005-03-29', 'J 08 - 15 C', '978-2070518425')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2070518425/002', '2010-05-13', 'J 08 - 16 C', '978-2070518425')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2070518425/003', '2015-06-06', 'J 08 - 17 C', '978-2070518425')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2268033945/001', '2016-02-02', 'H 02 - 23 R', '978-2268033945')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2848762142/001', '2012-10-15', 'H 82 - 93 R', '978-2848762142')");
			
			stmt.executeUpdate(
					"INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " +
					"VALUES ('978-2848762142/002', '2015-12-04', 'H 82 - 94 R', '978-2848762142')");

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
