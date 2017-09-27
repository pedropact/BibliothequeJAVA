package app;

import java.awt.BorderLayout;
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

import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Vector;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.JTable;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class FileAttente extends JFrame {

	private JPanel contentPane;
	public static String selectedClient;
	JTextField tf_IdClient;
	JTextField tf_Nom;
	JTextField tf_Prenom;
	JTextField tf_titreLivre;
	JTextField tf_Titre;
	JTextField tf_Auteur;
	public static JLabel lblLivre;
	public static JLabel lblNombreDuExemplaire;
	public static JLabel lblTitre;
	public static JLabel lblAuteur;
	public static JLabel lblAbonn;
	public static JLabel lblNewLabel;
	public static JLabel lblNom;
	public static JLabel lblPrenom;
	public static JLabel lbTitrePage;
	public static JButton btnSortir;
	public static JButton btFindExemplaire;
	public static JButton btnFindClient;
	public static JButton btnRechercherCodeDe;
	public static JButton btnRechercherClientFile;
	public static JButton btnPageRetAbonne;
	public static JButton btnConfirmerFille;
	public static JButton btnEffacerFile;
	public static JLabel lblDtEntre;
	public static JLabel lblCodeDeFile;
	public static int optionRecherche = 1;
	public static JTextField tf_IdFileAttente;
	public static JLabel lblRetirerUnAbonn;
	public static JTextField tfDtEntree;
	public static JButton btnChercherFile;
	public static Date dateEntree;
	public static SimpleDateFormat formatDate;
	static FindBookEx findBookEx; 
	static FindTitreFile findTitreFile;
	private FindClient findClient;
	 static FileAttente frameNewFileAttente= new FileAttente();
	

//deuxieme commit
	 
	 
	/**
	 * Launch the application.bvvvsssste
	 * hdgshghfdghfd hgdhfgdhgf
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					//FileAttente frame = new FileAttente();
					frameNewFileAttente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileAttente() {

		findClient = new FindClient();
		findBookEx = new FindBookEx();
		findTitreFile = new FindTitreFile();

		//  ----------------------------- LABELS ET TEXTFIELDS -----------------------------

		setBounds(100, 100, 742, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbTitrePage = new JLabel("File d'attente");
		lbTitrePage.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbTitrePage.setBounds(37, 23, 250, 30);
		contentPane.add(lbTitrePage);
		lbTitrePage.setVisible(true);


		lblLivre = new JLabel("LIVRE");
		lblLivre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLivre.setBounds(37, 108, 128, 14);
		contentPane.add(lblLivre);

		lblNombreDuExemplaire = new JLabel("Code du titre");
		lblNombreDuExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreDuExemplaire.setBounds(37, 138, 186, 14);
		contentPane.add(lblNombreDuExemplaire);

		lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitre.setBounds(37, 166, 147, 14);
		contentPane.add(lblTitre);

		lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuteur.setBounds(37, 194, 147, 14);
		contentPane.add(lblAuteur);

		lblAbonn = new JLabel("ABONN\u00C9E");
		lblAbonn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAbonn.setBounds(37, 259, 128, 14);
		contentPane.add(lblAbonn);

		lblNewLabel = new JLabel("Code d'Identification");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 292, 147, 14);
		contentPane.add(lblNewLabel);

		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(37, 320, 147, 14);
		contentPane.add(lblNom);

		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenom.setBounds(37, 348, 147, 14);
		contentPane.add(lblPrenom);

		tf_titreLivre = new JTextField();
		tf_titreLivre.setEditable(false);
		tf_titreLivre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_titreLivre.setColumns(10);
		tf_titreLivre.setBounds(233, 138, 159, 20);
		contentPane.add(tf_titreLivre);

		tf_Titre = new JTextField();
		tf_Titre.setEditable(false);
		tf_Titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Titre.setColumns(10);
		tf_Titre.setBounds(233, 166, 450, 20);
		contentPane.add(tf_Titre);

		tf_Auteur = new JTextField();
		tf_Auteur.setEditable(false);
		tf_Auteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Auteur.setColumns(10);
		tf_Auteur.setBounds(233, 194, 450, 20);
		contentPane.add(tf_Auteur);

		tf_IdClient = new JTextField();
		tf_IdClient.setEditable(false);
		tf_IdClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_IdClient.setBounds(233, 292, 159, 20);
		contentPane.add(tf_IdClient);
		tf_IdClient.setColumns(10);

		tf_Nom = new JTextField();
		tf_Nom.setEditable(false);
		tf_Nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Nom.setColumns(10);
		tf_Nom.setBounds(233, 320, 450, 20);
		contentPane.add(tf_Nom);

		tf_Prenom = new JTextField();
		tf_Prenom.setEditable(false);
		tf_Prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Prenom.setColumns(10);
		tf_Prenom.setBounds(233, 348, 450, 20);
		contentPane.add(tf_Prenom);

		
		tfDtEntree = new JTextField();
		tfDtEntree.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDtEntree.setEditable(false);
		tfDtEntree.setBounds(233, 416, 159, 20);
		contentPane.add(tfDtEntree);
		tfDtEntree.setColumns(10);
		dateEntree = new Date(System.currentTimeMillis());  
		formatDate = new SimpleDateFormat("yyyy-MM-dd"); 
		
		tfDtEntree.setText(formatDate.format(dateEntree));
		lblDtEntre = new JLabel("Date d'entr�e");
		lblDtEntre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDtEntre.setBounds(37, 419, 147, 14);
		contentPane.add(lblDtEntre);
		
		lblCodeDeFile = new JLabel("Code de file d'attente");
		lblCodeDeFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodeDeFile.setBounds(37, 458, 147, 14);
		contentPane.add(lblCodeDeFile);
		lblCodeDeFile.setVisible(false);
		
		tf_IdFileAttente = new JTextField();
		tf_IdFileAttente.setEditable(false);
		tf_IdFileAttente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_IdFileAttente.setColumns(10);
		tf_IdFileAttente.setBounds(233, 457, 159, 20);
		contentPane.add(tf_IdFileAttente);
		tf_IdFileAttente.setVisible(false);
		
		lblRetirerUnAbonn = new JLabel("Retirer un abonn\u00E9 de la file");
		lblRetirerUnAbonn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRetirerUnAbonn.setBounds(37, 23, 250, 30);
		contentPane.add(lblRetirerUnAbonn);
		lblRetirerUnAbonn.setVisible(false);
		
		//  ----------------------------- BOUTONS -----------------------------

		
		btnFindClient = new JButton("Rechercher un abonn�");
		btnFindClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findClient.setVisible(true);
				
				tf_Nom.setText("");
				tf_Prenom.setText("");
				tf_IdClient.setText("");
				tf_IdFileAttente.setText("");
				
			}
		});
		btnFindClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFindClient.setBounds(487, 378, 196, 23);
		contentPane.add(btnFindClient);

		btFindExemplaire = new JButton("Rechercher un titre");
		btFindExemplaire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				findTitreFile.setVisible(true);
				findBookEx.optionRecherche = "titre";
				tf_Auteur.setText("");
				tf_IdFileAttente.setText("");
				tf_Titre.setText("");
				tf_titreLivre.setText("");
			}
		});
		btFindExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btFindExemplaire.setBounds(487, 225, 196, 23);
		contentPane.add(btFindExemplaire);


		btnConfirmerFille = new JButton("Inclusion");
		btnConfirmerFille.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				ajouterFileAttente();
				JOptionPane.showMessageDialog(null, "Op�ration termin�e!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
				effacerChamps();
			}
		});
		btnConfirmerFille.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmerFille.setBounds(280, 527, 196, 23);
		contentPane.add(btnConfirmerFille);


		btnEffacerFile = new JButton("Exclusion");
		btnEffacerFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				effacerFileAttente();
				JOptionPane.showMessageDialog(null, "Op�ration termin�e!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
				effacerChamps();
				
			}
		});
		btnEffacerFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEffacerFile.setBounds(280, 527, 196, 23);
		contentPane.add(btnEffacerFile);
		btnEffacerFile.setVisible(false);


		btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				effacerChamps();
				setVisible(false);
			}
		});
		btnSortir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSortir.setBounds(486, 527, 196, 23);
		contentPane.add(btnSortir);

		
		btnPageRetAbonne = new JButton("Retirer un abonn� de la file");
		btnPageRetAbonne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPageRetAbonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnFindClient.setVisible(false);
				btnEffacerFile.setVisible(true);
				btnConfirmerFille.setVisible(false);
				lblDtEntre.setVisible(false);
				tfDtEntree.setVisible(false);
				btFindExemplaire.setVisible(false);
				btnChercherFile.setVisible(true);
				tf_IdFileAttente.setVisible(true);
				btnRechercherClientFile.setVisible(true);
				btnRechercherCodeDe.setVisible(true);
				lblCodeDeFile.setVisible(true);
				btnPageRetAbonne.setVisible(false);
				lblRetirerUnAbonn.setVisible(true);
				lbTitrePage.setVisible(false);
	
			}
		});
		btnPageRetAbonne.setBounds(455, 30, 228, 23);
		contentPane.add(btnPageRetAbonne);
		

		btnChercherFile = new JButton("Rechercher dans la file");
		btnChercherFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				findTitreFile.setVisible(true);
			}
		});
		btnChercherFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChercherFile.setBounds(487, 225, 196, 23);
		contentPane.add(btnChercherFile);
		btnChercherFile.setVisible(false);

		btnRechercherClientFile = new JButton("Rechercher dans la file");
		btnRechercherClientFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				findClient();
			}
		});
		btnRechercherClientFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRechercherClientFile.setBounds(487, 379, 196, 23);
		contentPane.add(btnRechercherClientFile);
		btnRechercherClientFile.setVisible(false);
		
		
		btnRechercherCodeDe = new JButton("Rechercher Code de File");
		btnRechercherCodeDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				findIdFile();
			}
		});
		btnRechercherCodeDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRechercherCodeDe.setBounds(487, 454, 196, 23);
		contentPane.add(btnRechercherCodeDe);
		btnRechercherCodeDe.setVisible(false);
		
		
	}

	//  ----------------------------- FONCTIONS -----------------------------


	// Fonction pour construir la table avec les resultats de la recherche
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		System.out.println(rs);
		ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		//int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= 3; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {

			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= 3; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}
		return new DefaultTableModel(data, columnNames);
	}

	

	// Fonction pour chercher client et completer la table avec les resultats de la recherche
	private void findClient() {

		String cbCritere = "SELECT * FROM client WHERE client.id_client IN "
				+ "(SELECT id_client FROM file_attente WHERE id_livreTitreAuteur = '" + tf_titreLivre.getText() + " ');";

		try{			
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			System.out.println();
			//====================================

			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(cbCritere);
			DefaultTableModel tm = buildTableModel(rs); 
			JTable table = new JTable(tm);			
			JScrollPane scrollPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			int p = 0;
			scrollPane.getComponent(p); 
			scrollPane.setPreferredSize(new Dimension(500, getComponentCount()+300));
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setPreferredSize(new Dimension(20, 0));
			JOptionPane.showMessageDialog(null, scrollPane);

			String queryClientSelectionne = "SELECT * FROM client WHERE id_client = ' " + (Integer)tm.getValueAt(table.getSelectedRows()[0],0)+ " ' ;";



			rs = stmt.executeQuery(queryClientSelectionne);
			if (rs.next()){
				//NewPret.selectedClient = (rs.getString("id_client"));
				tf_Nom.setText(rs.getString("nom"));
				tf_Prenom.setText(rs.getString("prenom"));
				tf_IdClient.setText(rs.getString("id_client"));	
			} 		
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Pour rechercher
	private void findIdFile() {

		String queryIdFile = "SELECT * FROM file_attente WHERE id_client = '" + tf_IdClient.getText() + "' AND id_livreTitreAuteur = '" + tf_titreLivre.getText() + "';";
		
		try{			
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			System.out.println();
			//====================================

			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queryIdFile);
			DefaultTableModel tm = buildTableModel(rs); 
			JTable table = new JTable(tm);			
			JScrollPane scrollPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			int p = 0;
			scrollPane.getComponent(p); 
			scrollPane.setPreferredSize(new Dimension(500, getComponentCount()+300));
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setPreferredSize(new Dimension(20, 0));
			JOptionPane.showMessageDialog(null, scrollPane);

			String queryClientSelectionne = "SELECT * FROM file_attente WHERE id_file = ' " + (Integer)tm.getValueAt(table.getSelectedRows()[0],0)+ " ' ;";



			rs = stmt.executeQuery(queryClientSelectionne);
			if (rs.next()){
				tf_IdFileAttente.setText(rs.getString("id_file"));
					
			} 		
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Pour effacer un enregistrement de file
	private void effacerFileAttente() {
		@SuppressWarnings("static-access")
		Integer id_fileAttente = Integer.parseInt(tf_IdClient.getText());
		String queryEffacerFileAttente = "DELETE FROM file_attente WHERE id_file = '" + tf_IdFileAttente.getText() + "';";
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

			stmt.executeUpdate( queryEffacerFileAttente );

			stmt.close();
			con.commit();

			//====================================
			con.close();

		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	// Pour generer un ID 
	public int find_id_livreTitreAuteur(String titre) {
		int idTitre = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "root");

			Statement stmt;
			stmt = (Statement) con.createStatement();

			String query = "SELECT id_livreTitreAuteur FROM livreinfo WHERE titre = '" + titre + "'";
			ResultSet rs = stmt.executeQuery(query);
			rs = stmt.executeQuery(query);
			if (rs.next()){
				idTitre = Integer.parseInt(rs.getString(1));
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return idTitre;
	}

	


	// Pour creer un ID de location
	public int defineIdFileAttente() {
		int idFile = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			Statement stmt;
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT DISTINCT id_file FROM file_attente ORDER BY id_file ASC");

			while(rs.next()){                            
				if(Integer.parseInt(rs.getString(1)) == idFile) {
					idFile++;
				}
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return idFile;
	}


	// Pour ajouter une location
	public void ajouterFileAttente() {

		Integer idClient = 	Integer.parseInt(tf_IdClient.getText());
		Integer idTitreAuteur = Integer.parseInt(tf_titreLivre.getText());

		String queryAjouterFileAttente = "INSERT INTO file_attente (id_file, dtEntree, id_client, id_livreTitreAuteur) " +
				"VALUES ('" + defineIdFileAttente() + "', '" + tfDtEntree.getText() + "', '" + idClient + "','"	+ idTitreAuteur + "')"; 

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
			stmt.executeUpdate( queryAjouterFileAttente );
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	// Pour retourner le livre
	public void deleteFile() {

		Integer idTitreAuteur = Integer.parseInt(tf_titreLivre.getText());
		String queryDeleteClient = "DELETE FROM `file_attente` WHERE `id_file` = '" + tf_titreLivre.getText() + "';";
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
			stmt.executeUpdate( queryDeleteClient );
			stmt.close();
			con.commit();
			con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void effacerChamps() {
		tf_Auteur.setText("");
		tf_IdClient.setText("");
		tf_IdFileAttente.setText("");
		tf_Nom.setText("");
		tf_Prenom.setText("");
		tf_Titre.setText("");
		tf_titreLivre.setText("");
	}
	
	
}

































