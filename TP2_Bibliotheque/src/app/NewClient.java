package app;

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


public class NewClient extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Nom;
	private JTextField tf_Prenom;
	private JTextField tf_Adresse;
	private JTextField tf_Telephone;
	private JTextField tf_Courriel;
	private JTextField tf_DtNaissance;
	private JTextField tf_IdClient;
	private Object Integer;
	private JTextField tf_Recherche;
	private JComboBox comboBoxCritRecherche;
	public int cbCritere = 0;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewClient frame = new NewClient();
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
	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	public NewClient() {



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Donn\u00E9es d'abonn\u00E9e");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(38, 48, 361, 14);
		contentPane.add(lblNewLabel);

		JLabel lblId = new JLabel("Code d'identification");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(38, 99, 194, 14);
		contentPane.add(lblId);

		tf_IdClient = new JTextField();
		tf_IdClient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_IdClient.setHorizontalAlignment(SwingConstants.CENTER);
		tf_IdClient.setEditable(false);

		tf_IdClient.setColumns(10);
		tf_IdClient.setBounds(237, 91, 219, 20);
		contentPane.add(tf_IdClient);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(39, 150, 193, 14);
		contentPane.add(lblNom);

		tf_Nom = new JTextField();
		tf_Nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Nom.setBounds(238, 142, 630, 20);
		contentPane.add(tf_Nom);
		tf_Nom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrenom.setBounds(38, 197, 194, 14);
		contentPane.add(lblPrenom);

		tf_Prenom = new JTextField();
		tf_Prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Prenom.setColumns(10);
		tf_Prenom.setBounds(238, 191, 630, 20);
		contentPane.add(tf_Prenom);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresse.setBounds(39, 248, 193, 14);
		contentPane.add(lblAdresse);

		tf_Adresse = new JTextField();
		tf_Adresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Adresse.setColumns(10);
		tf_Adresse.setBounds(238, 240, 630, 20);
		contentPane.add(tf_Adresse);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelephone.setBounds(39, 297, 193, 14);
		contentPane.add(lblTelephone);

		tf_Telephone = new JTextField();
		tf_Telephone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Telephone.setColumns(10);
		tf_Telephone.setBounds(238, 289, 630, 20);
		contentPane.add(tf_Telephone);

		JLabel lblCourriel = new JLabel("Courriel");
		lblCourriel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourriel.setBounds(39, 346, 193, 14);
		contentPane.add(lblCourriel);

		tf_Courriel = new JTextField();
		tf_Courriel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Courriel.setColumns(10);
		tf_Courriel.setBounds(238, 338, 630, 20);
		contentPane.add(tf_Courriel);

		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDeNaissance.setBounds(39, 395, 193, 14);
		contentPane.add(lblDateDeNaissance);

		tf_DtNaissance = new JTextField();
		tf_DtNaissance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_DtNaissance.setColumns(10);
		tf_DtNaissance.setBounds(238, 389, 630, 20);
		contentPane.add(tf_DtNaissance);

		JLabel lblRechercheDabonn = new JLabel("Recherche d'un abonn\u00E9");
		lblRechercheDabonn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRechercheDabonn.setBounds(39, 570, 244, 14);
		contentPane.add(lblRechercheDabonn);

		tf_Recherche = new JTextField();
		tf_Recherche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Recherche.setBounds(39, 597, 509, 20);
		contentPane.add(tf_Recherche);
		tf_Recherche.setColumns(10);

		JLabel lblCritreDeRecherche = new JLabel("Crit\u00E8re de recherche");
		lblCritreDeRecherche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCritreDeRecherche.setBounds(39, 642, 194, 14);
		contentPane.add(lblCritreDeRecherche);

		JButton btnNewButton_1 = new JButton("Modifier l'abonn\u00E9");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alertModifierClient();
			}
		});
		btnNewButton_1.setBounds(340, 479, 230, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Effacer l'abonné");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alertEffacerClient();
			}
		});
		btnNewButton_2.setBounds(638, 479, 230, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Ajouter l'abonné");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				alertAjouterClient();
			}
		});
		btnNewButton_3.setBounds(39, 479, 230, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nom = tf_Nom.getText();
				findClient(nom);
			}
		});
		btnNewButton.setBounds(398, 684, 150, 23);
		contentPane.add(btnNewButton);

		JButton btnNettoyerLesChamps = new JButton("Nettoyer les champs");
		btnNettoyerLesChamps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNettoyerLesChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nettoyerChamps();

			}
		});
		btnNettoyerLesChamps.setBounds(638, 432, 230, 23);
		contentPane.add(btnNettoyerLesChamps);

		JButton btnNewButton_4 = new JButton("Sortir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(638, 684, 230, 23);
		contentPane.add(btnNewButton_4);



		comboBoxCritRecherche = new JComboBox();
		comboBoxCritRecherche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCritRecherche.setModel(new DefaultComboBoxModel(new String[] {
				"-- Critère --", "  Nom", "  Prenom"}));
		comboBoxCritRecherche.setBounds(271, 639, 277, 20);
		contentPane.add(comboBoxCritRecherche);
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


	// Fonction pour chercher un client et completer la table avec les resultats de la recherche
	private void findClient(String nom) {

		cbCritere = comboBoxCritRecherche.getSelectedIndex();
		String critereRecherche = "";

		if (cbCritere == 0) {
			critereRecherche = "SELECT * FROM client" ; 
		}
		else if (cbCritere == 1) {
			critereRecherche = "SELECT * FROM client WHERE nom LIKE '%" + tf_Recherche.getText() + "%';"; 
		}
		else if (cbCritere == 2) {
			critereRecherche = "SELECT * FROM client WHERE prenom LIKE '%" + tf_Recherche.getText() + "%';";
		} 

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
			ResultSet rs = stmt.executeQuery(critereRecherche);
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
				tf_Nom.setText(rs.getString("nom"));
				tf_Prenom.setText(rs.getString("prenom"));
				tf_Adresse.setText(rs.getString("adresse"));
				tf_Telephone.setText(rs.getString("telephone"));
				tf_Courriel.setText(rs.getString("courriel"));
				tf_DtNaissance.setText(rs.getString("dtNaissance"));
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


	// Fonction pour creer un ID de client
	@SuppressWarnings("static-access")
	private int defineIdClient() {
		int idClient = 20170001;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			/*System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			System.out.println();*/
			//====================================

			Statement stmt;
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT DISTINCT id_client FROM client ORDER BY id_Client ASC");

			while(rs.next()){                            
				if(((java.lang.Integer) Integer).parseInt(rs.getString(1)) == idClient) {
					idClient++;
				}
			}

			rs.close();
			stmt.close();
			con.close();

			//System.out.println("ID = " + idClient);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return idClient;
	}



	// Fonction pour inserer un client dans la base de données
	public void ajouterClient() {

		@SuppressWarnings("static-access")
		//Integer id_client = ((java.lang.Integer) Integer).parseInt(tf_IdClient.getText());
		String nom = tf_Nom.getText();
		String prenom = tf_Prenom.getText();
		String adresse = tf_Adresse.getText();
		String telephone = tf_Telephone.getText();
		String courriel = tf_Courriel.getText();
		String dtNaissance = tf_DtNaissance.getText();

			String queryAjouterClient = "INSERT INTO client (id_client, prenom, nom, adresse, telephone, courriel, dtNaissance) " +
					"VALUES ('" + defineIdClient() +"', '"+ prenom +"', '"+ nom +"', '"+ adresse +"', '"+ telephone +"', '"+ courriel +"', '"+ dtNaissance +"')";

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
				stmt.executeUpdate( queryAjouterClient );
				stmt.close();
				con.commit();
				con.close();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
			nettoyerChamps();
	}


	// Fonction pour effacer un client dans la base de données
	public void effacerClient() {
		@SuppressWarnings("static-access")
		Integer id_client = ((java.lang.Integer) Integer).parseInt(tf_IdClient.getText());
		String queryEffacerClient = "DELETE FROM `client` WHERE `client`.`id_client` = '" + id_client + "';";
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

			stmt.executeUpdate( queryEffacerClient );

			stmt.close();
			con.commit();

			//====================================
			con.close();

		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

		nettoyerChamps();
	}


	// Fonction pour changer les données d'un client
	public void modifierClient() {
		@SuppressWarnings("static-access")
		Integer id_client = ((java.lang.Integer) Integer).parseInt(tf_IdClient.getText());
		String nom = tf_Nom.getText();
		String prenom = tf_Prenom.getText();
		String adresse = tf_Adresse.getText();
		String telephone = tf_Telephone.getText();
		String courriel = tf_Courriel.getText();
		String dtNaissance = tf_DtNaissance.getText();

		String queryModifierClient = "UPDATE `client` SET `prenom` = '" + prenom +"', "
				+ "`nom` = '" + nom +"', `adresse` = '" + adresse +"', `telephone` = '" + telephone +"', "
				+ "`courriel` = '" + courriel +"', `dtNaissance` = '" + dtNaissance +"' WHERE `client`.`id_client` = " + id_client +";";

		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			con.setAutoCommit(false);

			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate( queryModifierClient );
			stmt.close();
			con.commit();
			con.close();

		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		nettoyerChamps();	
	}

	public void nettoyerChamps() {
		tf_IdClient.setText("");
		tf_Nom.setText("");
		tf_Prenom.setText("");
		tf_Adresse.setText("");
		tf_Courriel.setText("");
		tf_Telephone.setText("");
		tf_DtNaissance.setText("");	
	}

	public void alertEffacerClient() {

		int i = JOptionPane.showConfirmDialog(
				null, 
				"Effacer l'abonné ?",
				"Effacer",
				JOptionPane.OK_CANCEL_OPTION
				);

		if(i == JOptionPane.YES_OPTION) {
			effacerClient();
		}
		else if(i == JOptionPane.NO_OPTION) {
		}
	}


	public void alertAjouterClient() {

		int i = JOptionPane.showConfirmDialog(
				null, 
				"Ajouter l'abonné ?",
				"Ajouter",
				JOptionPane.OK_CANCEL_OPTION
				);

		if(i == JOptionPane.YES_OPTION) {
			ajouterClient();
		}
		else if(i == JOptionPane.NO_OPTION) {
		}
	}


	public void alertModifierClient() {

		int i = JOptionPane.showConfirmDialog(
				null, 
				"Modifier les données ?",
				"Modifier",
				JOptionPane.OK_CANCEL_OPTION
				);

		if(i == JOptionPane.YES_OPTION) {
			modifierClient();
		}
		else if(i == JOptionPane.NO_OPTION) {
		}
	}
}
