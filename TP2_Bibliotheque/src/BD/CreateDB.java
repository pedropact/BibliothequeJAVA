package BD;
import java.sql.*;

public class CreateDB {
	
	public static void createDB() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			//====================================

			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("CREATE DATABASE biblio");

			stmt.close();
			con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
}

