package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {

	
	public static void createTables() {
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			//====================================
			Statement stmt;
			//====================================
			// TABLE AUTEUR
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE auteur" + 
							"(id_auteur INT PRIMARY KEY NOT NULL, " +
							"auteur TEXT NOT NULL)"
					);
			stmt.close();
			//====================================
			// TABLE TITRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE titre" + 
							"(id_titre INT PRIMARY KEY NOT NULL, " +
							"titre TEXT NOT NULL)"
					);
			stmt.close();
			//====================================
			// TABLE LANGUE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE langue" + 
							"(id_langue INT PRIMARY KEY NOT NULL, " +
							"langue TEXT NOT NULL)"
					);
			stmt.close();
			//====================================
			// TABLE GENRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE genre" + 
							"(id_genre INT PRIMARY KEY NOT NULL, " +
							"genre TEXT NOT NULL)"
					);
			stmt.close();
			//====================================
			// TABLE EDITEUR
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE editeur" + 
							"(id_editeur INT PRIMARY KEY NOT NULL, " +
							"editeur TEXT NOT NULL)"
					); 
			stmt.close();
			//====================================
			// TABLE CLIENT
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE client" + 
							"(id_client INT PRIMARY KEY NOT NULL, " +
							"prenom TEXT NOT NULL, " +
							"nom TEXT NOT NULL, " +
							"adresse TEXT NOT NULL, " +
							"telephone TEXT NOT NULL, " +
							"courriel TEXT, " +
							"dtNaissance DATE NOT NULL)" 
					); 
			stmt.close();
			//====================================
			// TABLE LIVRE_TITRE_AUTEUR
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE livre_titre_auteur" + 
							"(id_livreTitreAuteur INT PRIMARY KEY NOT NULL, " +
							"id_auteur INT NOT NULL, " +
							"id_genre INT NOT NULL, " +
							"id_titre INT NOT NULL, " +
							"FOREIGN KEY (id_auteur) REFERENCES auteur (id_auteur), " +
							"FOREIGN KEY (id_genre) REFERENCES genre (id_genre), " +
							"FOREIGN KEY (id_titre) REFERENCES titre (id_titre))" 
					); 
			 stmt.close();
			
			
			//====================================
			// TABLE LIVRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE livre" + 
							"(isbn VARCHAR(20) PRIMARY KEY NOT NULL, " +
							"rare BOOL NOT NULL, " +
							"id_editeur INT NOT NULL, " +
							"id_langue INT NOT NULL, " +
							"id_livreTitreAuteur INT NOT NULL, " +
							"FOREIGN KEY (id_livreTitreAuteur) REFERENCES livre_titre_auteur (id_livreTitreAuteur), " +
							"FOREIGN KEY (id_editeur) REFERENCES editeur (id_editeur), " +
							"FOREIGN KEY (id_langue) REFERENCES langue (id_langue))" 
					); 
			 stmt.close();
			//====================================
			// TABLE LIVRE_EXEMPLAIRE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE livre_exemplaire" + 
							"(num_ex VARCHAR(20) PRIMARY KEY NOT NULL, " +
							"dtPublication DATE NOT NULL, " +
							"adresse_ex TEXT NOT NULL, " +
							"isbn VARCHAR(20)NOT NULL, " +
							"FOREIGN KEY (isbn) REFERENCES livre (isbn))"
					); 
			 stmt.close();
			//====================================
			// TABLE LOCATION
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE location" + 
							"(id_location INT PRIMARY KEY NOT NULL, " +
							"dtDebut DATE NOT NULL, " +
							"id_client INT NOT NULL, " +
							"num_ex VARCHAR(20) NOT NULL, " +
							"dtFin DATE NOT NULL, " +
							"FOREIGN KEY (id_client) REFERENCES client (id_client), " +
							"FOREIGN KEY (num_ex) REFERENCES livre_exemplaire (num_ex))"
					); 
			 stmt.close();
			//====================================
			// TABLE FILE_ATTENTE
			stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE file_attente" + 
							"(id_file INT PRIMARY KEY NOT NULL, " +
							"dtEntree DATE NOT NULL, " +
							"id_client INT NOT NULL, " +
							"id_livreTitreAuteur INT NOT NULL, " +
							"FOREIGN KEY (id_livreTitreAuteur) REFERENCES livre_titre_auteur (id_livreTitreAuteur), " +
							"FOREIGN KEY (id_client) REFERENCES client (id_client))"
					); 
			 stmt.close();
			//====================================
			con.close();
			//====================================			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}



















