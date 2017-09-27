package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;

public class NewPret extends JFrame {

	private JPanel contentPane;
	public static String selectedClient;
	public static JTextField tf_IdClient;
	public static JTextField tf_Nom;
	public static JTextField tf_Prenom;
	public static JTextField tf_Exemplaire;
	public static JTextField tf_Titre;
	public static JTextField tf_Auteur;
	public static JTextField tf_DtDebut;
	public static JTextField tf_DtFin;
	public static JTextField tf_DtExtension;
	public static JLabel lblPretDeLivre;
	public static JLabel lblLivre;
	public static JLabel lblRetourDe;
	public static JLabel lblNombreDuExemplaire;
	public static JLabel lblTitre;
	public static JLabel lblAuteur;
	public static JLabel lblNouveauRtour;
	public static JLabel lblAbonn;
	public static JLabel lblNewLabel;
	public static JLabel lblNom;
	public static JLabel lblPrenom;
	public static JLabel lblPrt;
	public static JLabel lblDateDeDbut;
	public static JLabel lblDateDeRtour;
	public static JLabel lbExtension;
	public static JLabel lbOption;
	public static JButton btnConfirmerPret;
	public static JButton btnSortir;
	public static JButton btFindExemplaire;
	public static JButton btnFindClient;
	public static JButton btnRetour;
	public static JButton btnConfirmerLeRetour;
	public static JButton btnPretLivre;
	public static JButton btnConfirmerExtension;
	public static Date date;
	public static Date dateFin;
	public static Date dateExtension;
	public static SimpleDateFormat formatDate;
	private FindClient findClient;
	private FileAttente FileAttente;
	static NewPret frameNewPret= new NewPret();
	static FindBookEx FindBookEx; 
	public static int joursPret = (86400 * 14 * 1000);
	public static int joursExtension = (86400 * 14 * 1000);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					NewPret frame = new NewPret();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewPret() {

		findClient = new FindClient();
		FindBookEx = new FindBookEx();	
		FileAttente = new FileAttente();

		//  ----------------------------- LABELS ET TEXTFIELDS -----------------------------
		
		
		
		setBounds(100, 100, 745, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbOption = new JLabel("CHOISISSEZ UNE OPÉRATION");
		lbOption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbOption.setBounds(37, 86, 222, 14);
		contentPane.add(lbOption);
		
		
		lblPretDeLivre = new JLabel("Pr\u00EAt de livre");
		lblPretDeLivre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPretDeLivre.setBounds(37, 77, 250, 30);
		contentPane.add(lblPretDeLivre);
		lblPretDeLivre.setVisible(false);

		lblRetourDe = new JLabel("Retour de livre");
		lblRetourDe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRetourDe.setBounds(37, 77, 250, 30);
		contentPane.add(lblRetourDe);
		lblRetourDe.setVisible(false);

		lbExtension = new JLabel("Extension de pr\u00EAt");
		lbExtension.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbExtension.setBounds(37, 77, 250, 30);
		contentPane.add(lbExtension);
		lbExtension.setVisible(false);

		lblLivre = new JLabel("LIVRE");
		lblLivre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLivre.setBounds(37, 160, 128, 14);
		contentPane.add(lblLivre);

		lblNombreDuExemplaire = new JLabel("Nombre du exemplaire");
		lblNombreDuExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreDuExemplaire.setBounds(37, 190, 186, 14);
		contentPane.add(lblNombreDuExemplaire);

		lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitre.setBounds(37, 218, 147, 14);
		contentPane.add(lblTitre);

		lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuteur.setBounds(37, 246, 147, 14);
		contentPane.add(lblAuteur);

		lblAbonn = new JLabel("ABONN\u00C9E");
		lblAbonn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAbonn.setBounds(37, 311, 128, 14);
		contentPane.add(lblAbonn);

		lblNewLabel = new JLabel("Code d'Identification");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 344, 147, 14);
		contentPane.add(lblNewLabel);

		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(37, 372, 147, 14);
		contentPane.add(lblNom);

		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenom.setBounds(37, 400, 147, 14);
		contentPane.add(lblPrenom);

		lblPrt = new JLabel("PR\u00CAT");
		lblPrt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrt.setBounds(37, 464, 128, 20);
		contentPane.add(lblPrt);

		lblDateDeDbut = new JLabel("Date de d\u00E9but");
		lblDateDeDbut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeDbut.setBounds(37, 498, 128, 14);
		contentPane.add(lblDateDeDbut);

		lblDateDeRtour = new JLabel("Date de retour");
		lblDateDeRtour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeRtour.setBounds(37, 529, 128, 14);
		contentPane.add(lblDateDeRtour);

		lblNouveauRtour = new JLabel("Nouveau retour");
		lblNouveauRtour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNouveauRtour.setBounds(37, 560, 128, 14);
		contentPane.add(lblNouveauRtour);
		lblNouveauRtour.setVisible(false);

		
		
		tf_Exemplaire = new JTextField();
		tf_Exemplaire.setEditable(false);
		tf_Exemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Exemplaire.setColumns(10);
		tf_Exemplaire.setBounds(233, 190, 159, 20);
		contentPane.add(tf_Exemplaire);

		tf_Titre = new JTextField();
		tf_Titre.setEditable(false);
		tf_Titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Titre.setColumns(10);
		tf_Titre.setBounds(233, 218, 450, 20);
		contentPane.add(tf_Titre);

		tf_Auteur = new JTextField();
		tf_Auteur.setEditable(false);
		tf_Auteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Auteur.setColumns(10);
		tf_Auteur.setBounds(233, 246, 450, 20);
		contentPane.add(tf_Auteur);

		tf_IdClient = new JTextField();
		tf_IdClient.setEditable(false);
		tf_IdClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_IdClient.setBounds(233, 344, 159, 20);
		contentPane.add(tf_IdClient);
		tf_IdClient.setColumns(10);

		tf_Nom = new JTextField();
		tf_Nom.setEditable(false);
		tf_Nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Nom.setColumns(10);
		tf_Nom.setBounds(233, 372, 450, 20);
		contentPane.add(tf_Nom);

		tf_Prenom = new JTextField();
		tf_Prenom.setEditable(false);
		tf_Prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Prenom.setColumns(10);
		tf_Prenom.setBounds(233, 400, 450, 20);
		contentPane.add(tf_Prenom);

		tf_DtDebut = new JTextField();
		tf_DtDebut.setEditable(false);
		tf_DtDebut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_DtDebut.setBounds(233, 495, 102, 20);
		contentPane.add(tf_DtDebut);
		tf_DtDebut.setColumns(10);

		tf_DtFin = new JTextField();
		tf_DtFin.setEditable(false);
		tf_DtFin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_DtFin.setColumns(10);
		tf_DtFin.setBounds(233, 526, 102, 20);
		contentPane.add(tf_DtFin);

		tf_DtExtension = new JTextField();
		tf_DtExtension.setText("2017-09-09");
		tf_DtExtension.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_DtExtension.setEditable(false);
		tf_DtExtension.setColumns(10);
		tf_DtExtension.setBounds(233, 557, 102, 20);
		contentPane.add(tf_DtExtension);
		tf_DtExtension.setVisible(false);
		
		effacerChamps();
		
		//  ----------------------------- BOUTONS -----------------------------
		
		btnConfirmerPret = new JButton("Confirmer le prêt");
		btnConfirmerPret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterLocation();
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Opération terminée!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnFindClient = new JButton("Rechercher un abonné");
		btnFindClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findClient.setVisible(true);
			}
		});
		btnFindClient.setVisible(false);
		btnFindClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFindClient.setBounds(487, 430, 196, 23);
		contentPane.add(btnFindClient);

		btFindExemplaire = new JButton("Rechercher un livre");
		btFindExemplaire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FindBookEx.setVisible(true);
				FindBookEx.optionRecherche = "livre";
				dateExtension = new Date(System.currentTimeMillis() + joursExtension);  
				//tf_DtExtension.setText(formatDate.format(dateExtension));
			}
		});
		btFindExemplaire.setVisible(false);

		
		btnRetour = new JButton("RETOUR DE LIVRE");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBtnVisibleRetourLivre();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRetour.setBounds(508, 84, 153, 23);
		contentPane.add(btnRetour);


		btnPretLivre = new JButton("PRÊT DE LIVRE");
		btnPretLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBtnVisiblePret();		
			}
		});
		btnPretLivre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPretLivre.setBounds(313, 84, 153, 23);
		contentPane.add(btnPretLivre);

		btFindExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btFindExemplaire.setBounds(487, 277, 196, 23);
		contentPane.add(btFindExemplaire);
		
		

		btnConfirmerPret.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmerPret.setBounds(270, 611, 196, 23);
		contentPane.add(btnConfirmerPret);
		btnConfirmerPret.setVisible(false);

		btnConfirmerLeRetour = new JButton("Confirmer le retour");
		btnConfirmerLeRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				deleteLocation();
				effacerChamps();
				JOptionPane.showMessageDialog(null, "Opération terminée!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnConfirmerLeRetour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmerLeRetour.setBounds(270, 611, 196, 23);
		contentPane.add(btnConfirmerLeRetour);
		btnConfirmerLeRetour.setVisible(false);
		btnConfirmerLeRetour.setVisible(false);

		btnConfirmerExtension = new JButton("Confirmer l'extension");
		btnConfirmerExtension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterExtension();
			}
		});
		btnConfirmerExtension.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmerExtension.setBounds(270, 611, 196, 23);
		contentPane.add(btnConfirmerExtension);
		btnConfirmerExtension.setVisible(false);
		btnConfirmerLeRetour.setVisible(false);

		btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
			}
		});
		btnSortir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSortir.setBounds(491, 611, 196, 23);
		contentPane.add(btnSortir);
		
		JButton btnFileAttente = new JButton("File d'attente");
		btnFileAttente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileAttente.setVisible(true);
			}
		});
		btnFileAttente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFileAttente.setBounds(47, 611, 196, 23);
		contentPane.add(btnFileAttente);

		
		
	}

	//  ----------------------------- FONCTIONS -----------------------------

	// Pour creer un ID de location
	private int defineIdLocation() {
		int idLocation = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			Statement stmt;
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT DISTINCT id_location FROM location ORDER BY id_location ASC");

			while(rs.next()){                            
				if(Integer.parseInt(rs.getString(1)) == idLocation) {
					idLocation++;
				}
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return idLocation;
	}


	// Pour ajouter une location
	public void ajouterLocation() {
		String queryAjouterLocation = "INSERT INTO location (id_location, dtDebut, id_client, num_ex, dtFin) " +
				"VALUES ('" + defineIdLocation() +"', '"+ tf_DtDebut.getText() +"', '"+ tf_IdClient.getText() +"', "
				+ "'"+ tf_Exemplaire.getText() +"', '"+ tf_DtFin.getText() +"')";
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
			stmt = con.createStatement();
			stmt.executeUpdate( queryAjouterLocation );
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	// Pour faire l'extension du pret
	public void ajouterExtension() {
		String queryExtensionPret = "UPTADE location SET dtFin VALUES ('"+ tf_DtFin.getText() +"')";
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
			stmt = con.createStatement();
			stmt.executeUpdate( queryExtensionPret );
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// Pour retourner le livre
	public void deleteLocation() {
		String queryDeleteLocation = "DELETE FROM `location` WHERE `num_ex` = '" + tf_Exemplaire.getText() + "';";
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
			stmt = con.createStatement();
			stmt.executeUpdate( queryDeleteLocation );
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// Cherche l'ID du client qui a fait la location du livre
	public static void findIdClientLocation() {
		// TODO Auto-generated method stub
		String queryfindIdClientLocation = "SELECT * FROM `location` WHERE `num_ex` LIKE '" + tf_Exemplaire.getText() + "';";
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
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queryfindIdClientLocation);
			stmt = con.createStatement();
			stmt.executeQuery( queryfindIdClientLocation );
			if (rs.next()){
				tf_IdClient.setText(rs.getString("id_client"));
				tf_DtDebut.setText(rs.getString("dtDebut"));
				tf_DtFin.setText(rs.getString("dtFin"));
				System.out.println(rs.getString("id_client"));				
			}
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		findClientLocation();	
	}

	// Cherche le nom et prenom du client qui a fait la location du livre
	public static void findClientLocation() {
		// TODO Auto-generated method stub
		String queryfindClientLocation = "SELECT * FROM `client` WHERE `id_client` LIKE '" + tf_IdClient.getText() + "';";
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
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queryfindClientLocation);
			stmt = con.createStatement();
			stmt.executeQuery( queryfindClientLocation );
			if (rs.next()){
				tf_Nom.setText(rs.getString("nom"));
				tf_Prenom.setText(rs.getString("prenom"));
			}
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void effacerChamps() {
		tf_Exemplaire.setText("");
		tf_Titre.setText("");
		tf_Auteur.setText("");
		tf_IdClient.setText("");
		tf_Nom.setText("");
		tf_Prenom.setText("");
		tf_DtDebut.setText("");
		tf_DtFin.setText("");
		tf_DtExtension.setText("");
	}

	public void setBtnVisiblePret() {
		lbOption.setVisible(false);

		btnRetour.setVisible(false);
		btnPretLivre.setVisible(false);
		//btnExtension.setVisible(false);

		lblPretDeLivre.setVisible(true);
		lblRetourDe.setVisible(false);
		lbExtension.setVisible(false);

		btnFindClient.setVisible(true);
		btFindExemplaire.setVisible(true);

		tf_DtExtension.setVisible(false);
		lblNouveauRtour.setVisible(false);

		btnConfirmerPret.setVisible(true);
		btnConfirmerLeRetour.setVisible(false);
		btnConfirmerExtension.setVisible(false);

		date = new Date(System.currentTimeMillis());  
		formatDate = new SimpleDateFormat("yyyy-MM-dd"); 
		tf_DtDebut.setText(formatDate.format(date));

		dateFin = new Date(System.currentTimeMillis() + joursPret );  
		tf_DtFin.setText(formatDate.format(dateFin));

		FindBookEx.optionView = "livrelocation";
	}

	public void setBtnVisibleRetourLivre() {
		lbOption.setVisible(false);

		btnPretLivre.setVisible(false);
		btnRetour.setVisible(false);
		//btnExtension.setVisible(false);

		lblPretDeLivre.setVisible(false);
		lblRetourDe.setVisible(true);
		lbExtension.setVisible(false);

		btFindExemplaire.setVisible(true);
		btnFindClient.setVisible(false);

		lblNouveauRtour.setVisible(false);
		tf_DtExtension.setVisible(false);

		btnConfirmerPret.setVisible(false);
		btnConfirmerLeRetour.setVisible(true);
		btnConfirmerExtension.setVisible(false);

		FindBookEx.optionView = "livrelocationretour";
	}
}

































