package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateViews {
	
	
	public static void createViews() {
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
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view filecourant as "
					+ "select `biblio`.`file_attente`.`id_file` AS `id_file`,"
					+ "`biblio`.`file_attente`.`dtEntree` AS `dtEntree`,"
					+ "`biblio`.`file_attente`.`id_client` AS `id_client`,"
					+ "`biblio`.`file_attente`.`id_livreTitreAuteur` AS `id_livreTitreAuteur` "
					+ "from `biblio`.`file_attente`"
					);
			stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view livreinfo as "
					+ "select `biblio`.`livre`.`isbn` AS `isbn`,"
					+ "`biblio`.`livre`.`rare` AS `rare`,"
					+ "`biblio`.`editeur`.`editeur` AS `editeur`,"
					+ "`biblio`.`langue`.`langue` AS `langue`,"
					+ "`biblio`.`titre`.`titre` AS `titre`,"
					+ "`biblio`.`auteur`.`auteur` AS `auteur`,"
					+ "`biblio`.`genre`.`genre` AS `genre`,"
					+ "`biblio`.`livre_exemplaire`.`adresse_ex` AS `adresse_ex`,"
					+ "`biblio`.`livre_exemplaire`.`dtPublication` AS `dtPublication`,"
					+ "`biblio`.`livre_exemplaire`.`num_ex` AS `num_exemplaire` "
					+ "from (((((((`biblio`.`livre` join `biblio`.`editeur`) join `biblio`.`langue`) "
					+ "join `biblio`.`livre_titre_auteur`) "
					+ "join `biblio`.`titre`) "
					+ "join `biblio`.`auteur`) "
					+ "join `biblio`.`genre`) "
					+ "join `biblio`.`livre_exemplaire`) "
					+ "where ((`biblio`.`livre`.`id_editeur` = `biblio`.`editeur`.`id_editeur`) "
					+ "and (`biblio`.`livre`.`id_langue` = `biblio`.`langue`.`id_langue`) "
					+ "and (`biblio`.`livre`.`id_livreTitreAuteur` = `biblio`.`livre_titre_auteur`.`id_livreTitreAuteur`) "
					+ "and (`biblio`.`livre_titre_auteur`.`id_titre` = `biblio`.`titre`.`id_titre`) "
					+ "and (`biblio`.`livre_titre_auteur`.`id_auteur` = `biblio`.`auteur`.`id_auteur`) "
					+ "and (`biblio`.`livre_titre_auteur`.`id_genre` = `biblio`.`genre`.`id_genre`) "
					+ "and (`biblio`.`livre`.`isbn` = `biblio`.`livre_exemplaire`.`isbn`))"
					);
			stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view livre2 as "
					+ "select `biblio`.`livre`.`isbn` AS `isbn`,"
					+ "`biblio`.`livre`.`rare` AS `rare`,"
					+ "`biblio`.`editeur`.`editeur` AS `editeur`,"
					+ "`biblio`.`langue`.`langue` AS `langue`,"
					+ "`biblio`.`livre`.`id_livreTitreAuteur` AS `id_livreTitreAuteur` "
					+ "from ((`biblio`.`livre` join `biblio`.`editeur` "
					+ "on((`biblio`.`livre`.`id_editeur` = `biblio`.`editeur`.`id_editeur`))) "
					+ "join `biblio`.`langue` on((`biblio`.`livre`.`id_langue` = `biblio`.`langue`.`id_langue`)))"
					);
			stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view livrelocation as "
					+ "select `livreinfo`.`isbn` AS `isbn`,"
					+ "`livreinfo`.`rare` AS `rare`,"
					+ "`livreinfo`.`editeur` AS `editeur`,"
					+ "`livreinfo`.`langue` AS `langue`,"
					+ "`livreinfo`.`titre` AS `titre`,"
					+ "`livreinfo`.`auteur` AS `auteur`,"
					+ "`livreinfo`.`genre` AS `genre`,"
					+ "`livreinfo`.`adresse_ex` AS `adresse_ex`,"
					+ "`livreinfo`.`dtPublication` AS `dtPublication`,"
					+ "`livreinfo`.`num_exemplaire` AS `num_exemplaire` "
					+ "from `biblio`.`livreinfo` "
					+ "where `livreinfo`.`num_exemplaire` "
					+ "in (select `biblio`.`location`.`num_ex` from `biblio`.`location`)"
					); 
			stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view livrelocationretour as "
					+ "select `livreinfo`.`isbn` AS `isbn`,"
					+ "`livreinfo`.`rare` AS `rare`,"
					+ "`livreinfo`.`editeur` AS `editeur`,"
					+ "`livreinfo`.`langue` AS `langue`,"
					+ "`livreinfo`.`titre` AS `titre`,"
					+ "`livreinfo`.`auteur` AS `auteur`,"
					+ "`livreinfo`.`genre` AS `genre`,"
					+ "`livreinfo`.`adresse_ex` AS `adresse_ex`,"
					+ "`livreinfo`.`dtPublication` AS `dtPublication`,"
					+ "`livreinfo`.`num_exemplaire` AS `num_exemplaire` "
					+ "from `biblio`.`livreinfo` "
					+ "where `livreinfo`.`num_exemplaire` "
					+ "in (select `biblio`.`location`.`num_ex` from `biblio`.`location`)"
					); 
			stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view livretitreauteur2 as "
					+ "select `biblio`.`livre_titre_auteur`.`id_livreTitreAuteur` AS `id_livreTitreAuteur`,"
					+ "`biblio`.`titre`.`titre` AS `titre`,"
					+ "`biblio`.`auteur`.`auteur` AS `auteur`,"
					+ "`biblio`.`genre`.`genre` AS `genre` "
					+ "from (((`biblio`.`livre_titre_auteur` "
					+ "join `biblio`.`titre` "
					+ "on((`biblio`.`livre_titre_auteur`.`id_titre` = `biblio`.`titre`.`id_titre`))) "
					+ "join `biblio`.`auteur` on((`biblio`.`livre_titre_auteur`.`id_auteur` = `biblio`.`auteur`.`id_auteur`))) "
					+ "join `biblio`.`genre` on((`biblio`.`livre_titre_auteur`.`id_genre` = `biblio`.`genre`.`id_genre`)))" 
					); 
			stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view recherche as "
					+ "select `biblio`.`livre`.`isbn` AS `isbn`,"
					+ "`biblio`.`livre`.`rare` AS `rare`,"
					+ "`biblio`.`editeur`.`editeur` AS `editeur`,"
					+ "`biblio`.`langue`.`langue` AS `langue`,"
					+ "`biblio`.`titre`.`titre` AS `titre`,"
					+ "`biblio`.`auteur`.`auteur` AS `auteur`,"
					+ "`biblio`.`genre`.`genre` AS `genre` from "
					+ "((((((`biblio`.`livre` join `biblio`.`editeur`) "
					+ "join `biblio`.`langue`) "
					+ "join `biblio`.`livre_titre_auteur`) "
					+ "join `biblio`.`titre`) "
					+ "join `biblio`.`auteur`) "
					+ "join `biblio`.`genre`) "
					+ "where ((`biblio`.`livre`.`id_editeur` = `biblio`.`editeur`.`id_editeur`) "
					+ "and (`biblio`.`livre`.`id_langue` = `biblio`.`langue`.`id_langue`) "
					+ "and (`biblio`.`livre`.`id_livreTitreAuteur` = `biblio`.`livre_titre_auteur`.`id_livreTitreAuteur`) "
					+ "and (`biblio`.`livre_titre_auteur`.`id_titre` = `biblio`.`titre`.`id_titre`) "
					+ "and (`biblio`.`livre_titre_auteur`.`id_auteur` = `biblio`.`auteur`.`id_auteur`) "
					+ "and (`biblio`.`livre_titre_auteur`.`id_genre` = `biblio`.`genre`.`id_genre`))" 
					); 
			 stmt.close();
			//====================================
			stmt = con.createStatement();
			stmt.executeUpdate(
					"create view titreauteur as "
					+ "select distinct `file`.`titre` AS `titre`,"
					+ "`file`.`auteur` AS `auteur`,"
					+ "`lta`.`id_livreTitreAuteur` AS `id_livreTitreAuteur`,"
					+ "`biblio`.`genre`.`genre` AS `genre`,"
					+ "`biblio`.`langue`.`langue` AS `langue`,"
					+ "`biblio`.`livre`.`isbn` AS `isbn` "
					+ "from ((((((`biblio`.`livrelocationretour` `file` join `biblio`.`auteur` "
					+ "on((`biblio`.`auteur`.`auteur` = `file`.`auteur`))) "
					+ "join `biblio`.`titre` on((`biblio`.`titre`.`titre` = `file`.`titre`))) "
					+ "join `biblio`.`livre_titre_auteur` `lta` on(((`lta`.`id_auteur` = `biblio`.`auteur`.`id_auteur`) "
					+ "and (`lta`.`id_titre` = `biblio`.`titre`.`id_titre`)))) join `biblio`.`genre` "
					+ "on((`biblio`.`genre`.`id_genre` = `lta`.`id_genre`))) "
					+ "join `biblio`.`livre` on((`biblio`.`livre`.`id_livreTitreAuteur` = `lta`.`id_livreTitreAuteur`))) "
					+ "join `biblio`.`langue` on((`biblio`.`langue`.`id_langue` = `biblio`.`livre`.`id_langue`))) "
					+ "where (not(`file`.`titre` in (select `livrelocation`.`titre` from `biblio`.`livrelocation`)))" 
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
