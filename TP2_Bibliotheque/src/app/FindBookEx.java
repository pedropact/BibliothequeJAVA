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

public class FindBookEx extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldISBN;
	private JTextField textFieldAuthor;
	public JTextField textFieldExemplaire;
	private JComboBox comboBoxGenre;
	private JComboBox comboBoxEditor;
	private JComboBox comboBoxLanguage;	
	static public String selectComboValuesAuteur;
	static public String selectComboValuesGenre;
	static public String selectComboValuesLangue;	
	static public JCheckBox chbxRare;	
	static public String optionView = "";
	static FindBookEx frameFindBookEx = new FindBookEx();
	private JFrame frame;
	static public String optionRecherche = "livre";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindBookEx frame = new FindBookEx();
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
	public FindBookEx() {

		//  ----------------------------- LABELS ET TEXTFIELDS -----------------------------

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRechercherUnLivre = new JLabel("Rechercher un livre");
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

		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEditeur.setBounds(41, 301, 115, 14);
		contentPane.add(lblEditeur);

		JLabel lblLangue = new JLabel("Langue");
		lblLangue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLangue.setBounds(41, 348, 115, 14);
		contentPane.add(lblLangue);

		JLabel lblRare = new JLabel("Rare");
		lblRare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRare.setBounds(41, 402, 115, 14);
		contentPane.add(lblRare);

		JLabel lblExemplaire = new JLabel("Exemplaire");
		lblExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExemplaire.setBounds(41, 448, 115, 14);
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

		textFieldExemplaire = new JTextField();
		textFieldExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldExemplaire.setColumns(10);
		textFieldExemplaire.setBounds(157, 445, 278, 20);
		contentPane.add(textFieldExemplaire);

		//  ----------------------------- CHECK BOX -----------------------------

		chbxRare = new JCheckBox("");
		chbxRare.setBounds(157, 398, 97, 23);
		contentPane.add(chbxRare);

		//  ----------------------------- COMBO BOX -----------------------------

		selectComboValuesGenre = "SELECT DISTINCT genre FROM genre ORDER BY genre ASC";
		comboBoxGenre = new JComboBox();
		comboBoxGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxGenre.setBounds(157, 247, 278, 20);
		contentPane.add(comboBoxGenre);
		createCombo(comboBoxGenre, selectComboValuesGenre);

		selectComboValuesAuteur = "SELECT DISTINCT editeur FROM editeur ORDER BY editeur ASC";
		comboBoxEditor = new JComboBox();
		comboBoxEditor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxEditor.setBounds(157, 298, 278, 20);
		contentPane.add(comboBoxEditor);
		createCombo(comboBoxEditor, selectComboValuesAuteur);

		selectComboValuesLangue = "SELECT DISTINCT langue FROM langue ORDER BY langue ASC";
		comboBoxLanguage = new JComboBox();
		comboBoxLanguage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxLanguage.setBounds(157, 345, 278, 20);
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
		bt_Rechercher.setBounds(467, 498, 169, 23);
		contentPane.add(bt_Rechercher);

		JButton tb_Sortir = new JButton("Sortir");
		tb_Sortir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tb_Sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				setVisible(false);
				effacerChamps();
			}
		});
		tb_Sortir.setBounds(467, 545, 169, 23);
		contentPane.add(tb_Sortir);

		JButton bt_EffacerChamps = new JButton("Effacer les champs");
		bt_EffacerChamps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_EffacerChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				effacerChamps();
			}
		});
		bt_EffacerChamps.setBounds(273, 545, 169, 23);
		contentPane.add(bt_EffacerChamps);

		JButton bt_Ok = new JButton("OK");
		bt_Ok.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				NewPret.tf_Exemplaire.setText(textFieldExemplaire.getText());
				NewPret.tf_Titre.setText(textFieldTitle.getText());
				NewPret.tf_Auteur.setText(textFieldAuthor.getText());
				
				setVisible(false);
				effacerChamps();
				NewPret.findIdClientLocation();			
			}
		});
		bt_Ok.setBounds(71, 545, 169, 23);
		contentPane.add(bt_Ok);
	}

	//  ----------------------------- FONCTIONS -----------------------------
	
	
	public void findTitre() {
		
		
		
	}
	
	
	public void createRechercheLivre() {
		
		if(textFieldISBN.getText().length() == 0 && textFieldISBN.getText().length() == 0 && textFieldTitle.getText().length() == 0 && textFieldExemplaire.getText().length() == 0 && 
				textFieldAuthor.getText().length() == 0 && comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") &&
				comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") && comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")){
			JOptionPane.showMessageDialog(null, "Aucune valeur a été entré pour faire la recherche!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			String selectQuery = "";
			// ***** Search by Exemplaire
			if (textFieldExemplaire.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + optionView + "  WHERE num_exemplaire LIKE '%" + textFieldExemplaire.getText() + "%'";

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
				if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by Title
			else if (textFieldTitle.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + optionView + "  WHERE titre LIKE '%" + textFieldTitle.getText() + "%'";
				if (textFieldISBN.getText().length() > 0) {
					selectQuery += " AND isbn LIKE '%" + textFieldISBN.getText() + "%'";
				}
				if (textFieldAuthor.getText().length() > 0) {
					selectQuery += " AND auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				}
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by ISBN
			else if (textFieldISBN.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + optionView + " WHERE isbn LIKE '%" + textFieldISBN.getText() + "%'";
				if (textFieldAuthor.getText().length() > 0) {
					selectQuery += " AND auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				}
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by Author
			else if (textFieldAuthor.getText().length() > 0) {
				selectQuery = "SELECT * FROM " + optionView + " WHERE auteur LIKE '%" + textFieldAuthor.getText() + "%'";
				if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				}
				if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by Genre
			else if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
				selectQuery = "SELECT * FROM " + optionView + " WHERE genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
				if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
				}
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by Editor
			else if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
				selectQuery = "SELECT * FROM " + optionView + " WHERE editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
				if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
					selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				}
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by Language
			else if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
				selectQuery = "SELECT * FROM " + optionView + " WHERE langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
				if (chbxRare.isSelected()){
					selectQuery += " AND rare = 1";
				}
			}
			// ***** Search by Rare
			else if (chbxRare.isSelected()) {
				selectQuery = "SELECT * FROM " + optionView + " WHERE rare = 1";
			}

			findBook(selectQuery);
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

	// Fonction pour rechercher un livre
	private void findBook(String query) {
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
			String loadSelectedBook = "SELECT * FROM " + optionView + " WHERE isbn = '" + tm.getValueAt(table.getSelectedRows()[0],0)+ "'";
			rs = stmt.executeQuery(loadSelectedBook);
			if (rs.next()){

				textFieldTitle.setText(rs.getString("titre"));
				textFieldISBN.setText(rs.getString("isbn"));
				textFieldAuthor.setText(rs.getString("auteur"));
				comboBoxGenre.setSelectedItem(rs.getString("genre"));
				comboBoxEditor.setSelectedItem(rs.getString("editeur"));
				comboBoxLanguage.setSelectedItem(rs.getString("langue"));
				textFieldExemplaire.setText(rs.getString("num_exemplaire"));		
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

	// Fonction pour chercher livre et completer la table avec les resultats de la recherche
	private int find_id_livreTitreAuteur(String isbn) {
		int id = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = (Connection) DriverManager.getConnection(url, "root", "root");

			Statement stmt;
			stmt = (Statement) con.createStatement();

			String query = "SELECT id_livreTitreAuteur FROM livre WHERE isbn = '" + isbn + "'";
			ResultSet rs = stmt.executeQuery(query);
			rs = stmt.executeQuery(query);
			if (rs.next()){
				id = Integer.parseInt(rs.getString(1));
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}


	public void effacerChamps() {	
		textFieldAuthor.setText("");
		textFieldExemplaire.setText("");
		textFieldISBN.setText("");
		textFieldTitle.setText("");
		comboBoxGenre.setSelectedIndex(0);
		comboBoxEditor.setSelectedIndex(0);
		comboBoxLanguage.setSelectedIndex(0);
		chbxRare.setSelected(false);	
	}

}



