package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindTitreFile extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldISBN;
	private JTextField textFieldAuthor;
	private JComboBox comboBoxGenre;
	private JComboBox comboBoxLanguage;	
	static public String selectComboValuesAuteur;
	static public String selectComboValuesGenre;
	static public String selectComboValuesLangue;	
	static public String viewRechercheTitre = "titreauteur";
	static FindTitreFile frameFindTitreFile = new FindTitreFile();
	private JFrame frame;
	static public String optionRecherche = "livre";
	private JTextField textFieldIdTitreAuteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindTitreFile frame = new FindTitreFile();
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
	public FindTitreFile() {

		//  ----------------------------- LABELS ET TEXTFIELDS -----------------------------

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRechercherUnLivre = new JLabel("Rechercher un titre");
		lblRechercherUnLivre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRechercherUnLivre.setBounds(41, 50, 257, 20);
		contentPane.add(lblRechercherUnLivre);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitre.setBounds(41, 112, 115, 14);
		contentPane.add(lblTitre);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsbn.setBounds(41, 155, 115, 14);
		contentPane.add(lblIsbn);

		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuteur.setBounds(41, 204, 115, 14);
		contentPane.add(lblAuteur);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenre.setBounds(41, 250, 115, 14);
		contentPane.add(lblGenre);

		JLabel lblLangue = new JLabel("Langue");
		lblLangue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLangue.setBounds(41, 298, 115, 14);
		contentPane.add(lblLangue);

		JLabel lblExemplaire = new JLabel("Code du titre");
		lblExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExemplaire.setBounds(41, 347, 115, 14);
		contentPane.add(lblExemplaire);

		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTitle.setBounds(157, 109, 278, 20);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		textFieldISBN = new JTextField();
		textFieldISBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldISBN.setColumns(10);
		textFieldISBN.setBounds(157, 152, 278, 20);
		contentPane.add(textFieldISBN);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(157, 201, 278, 20);
		contentPane.add(textFieldAuthor);

		//  ----------------------------- COMBO BOX -----------------------------

		selectComboValuesGenre = "SELECT DISTINCT genre FROM genre ORDER BY genre ASC";
		comboBoxGenre = new JComboBox();
		comboBoxGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxGenre.setBounds(157, 247, 278, 20);
		contentPane.add(comboBoxGenre);
		createCombo(comboBoxGenre, selectComboValuesGenre);

		selectComboValuesAuteur = "SELECT DISTINCT editeur FROM editeur ORDER BY editeur ASC";

		selectComboValuesLangue = "SELECT DISTINCT langue FROM langue ORDER BY langue ASC";
		comboBoxLanguage = new JComboBox();
		comboBoxLanguage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxLanguage.setBounds(157, 295, 278, 20);
		contentPane.add(comboBoxLanguage);
		createCombo(comboBoxLanguage, selectComboValuesLangue);

		//  ----------------------------- BOUTONS -----------------------------

		JButton bt_Rechercher = new JButton("Rechercher");
		bt_Rechercher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_Rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					createRechercheLivre();
					
			}
		});
		bt_Rechercher.setBounds(475, 406, 169, 23);
		contentPane.add(bt_Rechercher);

		JButton tb_Sortir = new JButton("Sortir");
		tb_Sortir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tb_Sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				setVisible(false);
				effacerChamps();
			}
		});
		tb_Sortir.setBounds(475, 453, 169, 23);
		contentPane.add(tb_Sortir);

		JButton bt_EffacerChamps = new JButton("Effacer les champs");
		bt_EffacerChamps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_EffacerChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				effacerChamps();
			}
		});
		bt_EffacerChamps.setBounds(281, 453, 169, 23);
		contentPane.add(bt_EffacerChamps);

		JButton bt_Ok = new JButton("OK");
		bt_Ok.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				FileAttente.frameNewFileAttente.tf_titreLivre.setText(textFieldIdTitreAuteur.getText());
				FileAttente.frameNewFileAttente.tf_Titre.setText(textFieldTitle.getText());
				FileAttente.frameNewFileAttente.tf_Auteur.setText(textFieldAuthor.getText());
				
				setVisible(false);
				effacerChamps();			
			}
		});
		bt_Ok.setBounds(79, 453, 169, 23);
		contentPane.add(bt_Ok);
		
		textFieldIdTitreAuteur = new JTextField();
		textFieldIdTitreAuteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldIdTitreAuteur.setColumns(10);
		textFieldIdTitreAuteur.setBounds(157, 346, 278, 20);
		contentPane.add(textFieldIdTitreAuteur);
	}

	//  ----------------------------- FONCTIONS -----------------------------
	
	
	
	
	public void createRechercheLivre() {
		
		if(textFieldISBN.getText().length() == 0 && textFieldISBN.getText().length() == 0 && textFieldTitle.getText().length() == 0 && textFieldIdTitreAuteur.getText().length() == 0 && 
				textFieldAuthor.getText().length() == 0 && comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") &&
				 comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")){
			JOptionPane.showMessageDialog(null, "Aucune valeur a été entré pour faire la recherche!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			String selectQuery = "";
			// ***** Search by Exemplaire
			if (textFieldIdTitreAuteur.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + viewRechercheTitre + "  WHERE num_exemplaire LIKE '%" + textFieldIdTitreAuteur.getText() + "%'";
				if (textFieldTitle.getText().length() > 0) {
					selectQuery += " AND titre LIKE '%" + textFieldTitle.getText() + "%'";
				}
				if (textFieldISBN.getText().length() > 0) {
					selectQuery += " AND isbn LIKE '%" + textFieldISBN.getText() + "%'";
				}
				if (textFieldAuthor.getText().length() > 0) {
					selectQuery += " AND auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				}
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}				
			}
			// ***** Search by Title
			else if (textFieldTitle.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + viewRechercheTitre + "  WHERE titre LIKE '%" + textFieldTitle.getText() + "%'";
				if (textFieldISBN.getText().length() > 0) {
					selectQuery += " AND isbn LIKE '%" + textFieldISBN.getText() + "%'";
				}
				if (textFieldAuthor.getText().length() > 0) {
					selectQuery += " AND auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				}
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}				
			}
			// ***** Search by ISBN
			else if (textFieldISBN.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + viewRechercheTitre + " WHERE isbn LIKE '%" + textFieldISBN.getText() + "%'";
				if (textFieldAuthor.getText().length() > 0) {
					selectQuery += " AND auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				}
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}				
			}
			// ***** Search by Author
			else if (textFieldAuthor.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + viewRechercheTitre + " WHERE auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}				
			}
			// ***** Search by Genre
			else if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
				selectQuery = "SELECT * FROM " + viewRechercheTitre + " WHERE genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}				
			}			
			// ***** Search by Language
			else if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
				selectQuery = "SELECT * FROM " + viewRechercheTitre + " WHERE langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
			}
			

			findTitre(selectQuery);
		}	
		
	}
	
	
	// Fonction pour creer combobox avec colonne de la base de données
	static void createCombo(JComboBox combo, String query) {
		try{
			combo.addItem("-- SÉLÉCTIONNER --");

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "root");


			Statement stmt;
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){                            
				combo.addItem(rs.getString(1));
			}
			rs.close();
			stmt.close();
			con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Fonction pour construir la table avec les resultats de la recherche
		public static DefaultTableModel buildTableModel(ResultSet rs)
				throws SQLException {

			System.out.println(rs);
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

			Vector<String> columnNames = new Vector<String>();
			int columnCount = metaData.getColumnCount();
			for (int column = 1; column <= columnCount; column++) {
				columnNames.add(metaData.getColumnName(column));
			}

			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while (rs.next()) {
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
			return new DefaultTableModel(data, columnNames);
		}
	
	// Fonction pour rechercher un livre
	private void findTitre(String query) {
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "root");

			Statement stmt;
			stmt = (Statement) con.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			DefaultTableModel tm = buildTableModel(rs); 
			JTable table = new JTable(tm); 

			JScrollPane scrollPane = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			int p = 0;
			scrollPane.getComponent(p); 
			scrollPane.setPreferredSize(new Dimension(1000, getComponentCount()+300));
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setPreferredSize(new Dimension(20, 0));
			JOptionPane.showMessageDialog(null, scrollPane);
			String loadSelectedBook = "SELECT * FROM " + viewRechercheTitre + " WHERE isbn = '" + tm.getValueAt(table.getSelectedRows()[0],5)+ "'";
			rs = stmt.executeQuery(loadSelectedBook);
			if (rs.next()){

				textFieldTitle.setText(rs.getString("titre"));
				textFieldISBN.setText(rs.getString("isbn"));
				textFieldAuthor.setText(rs.getString("auteur"));
				comboBoxGenre.setSelectedItem(rs.getString("genre"));
				comboBoxLanguage.setSelectedItem(rs.getString("langue"));
				textFieldIdTitreAuteur.setText(rs.getString("id_livreTitreAuteur"));
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void effacerChamps() {	
		textFieldAuthor.setText("");
		textFieldIdTitreAuteur.setText("");
		textFieldISBN.setText("");
		textFieldTitle.setText("");
		comboBoxGenre.setSelectedIndex(0);
		comboBoxLanguage.setSelectedIndex(0);
	}
}



