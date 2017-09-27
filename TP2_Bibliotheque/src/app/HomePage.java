package app;
//==================================================
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
//==================================================
@SuppressWarnings("serial")
public class HomePage extends JFrame {
	//==================================================
	private JFrame frame;
	private NewClient client;
	private NewPret pret;
	private FileAttente file;
	private Retard retard;
	private JTextField textFieldTitle;
	private JTextField textFieldISBN;
	private JTextField textFieldAuthor;
	private JComboBox comboBoxGenre;
	private JComboBox comboBoxEditor;
	private JComboBox comboBoxLanguage;
	private JCheckBox chbxRare;
	private JButton btnRechercher;
	private JButton btnEffacerLivre;
	private JLabel lblPublishedDate;
	private JLabel lblAddress;
	private JLabel lblNumExemplaire;
	private JButton btnEffacerChamps;
	static FindTitreFile findTitreFile;
	//==================================================
	// Constructor
	public HomePage() {
		createMenuAndToolbar();
		fieldsOfSearching();
		searchButton();
		client = new NewClient();
		pret = new NewPret();
		file = new FileAttente();
		retard = new Retard();
		findTitreFile = new FindTitreFile();
	}
	//==================================================
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//==================================================
	public static void
	setFrame(final JFrame frame, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame.setTitle(frame.getClass().getSimpleName());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(width, height);
				frame.setVisible(true);
			}
		});
	}
	//==================================================
	private void createMenuAndToolbar() {
		frame = new JFrame();
		frame.setTitle("Page d'accueil");
		frame.setBounds(100, 100, 700, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//==================================================
		JMenuBar menuToolBar = new JMenuBar();
		menuToolBar.setEnabled(false);
		menuToolBar.setBounds(0, 0, 1184, 21);
		frame.getContentPane().add(menuToolBar);

		//==================================================
		// ***** Menu LIVRE
		JMenu menuLivre = new JMenu("Livre");
		menuToolBar.add(menuLivre);

		// ----- Itens Menu LIVRE
		JMenuItem itemNewBook = new JMenuItem("Nouveau livre");
		itemNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewBook.frameNewBook.setVisible(true);
			}
		});
		menuLivre.add(itemNewBook);
		/*menuLivre.addSeparator(); 

		JMenuItem itemDeleteBook = new JMenuItem("Effacer livre");
		itemDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewBook.frameNewBook.setVisible(true);
			}
		});
		menuLivre.add(itemDeleteBook);*/
		//==================================================
		// ***** Menu CLIENT
		JMenu menuClient = new JMenu("Client");
		menuToolBar.add(menuClient);

		// ----- Itens Menu CLIENT
		JMenuItem itemFindClient = new JMenuItem("Rechercher Client");
		itemFindClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.setVisible(true);
			}
		});
		menuClient.add(itemFindClient);
		menuClient.addSeparator();

		JMenuItem itemNewClient = new JMenuItem("Nouveau Client");
		itemNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.setVisible(true);
			}
		});
		menuClient.add(itemNewClient);
		menuClient.addSeparator();

		JMenuItem itemDeleteClient = new JMenuItem("Effacer Client");
		itemDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.setVisible(true);
			}
		});
		menuClient.add(itemDeleteClient);
		//==================================================
		// ***** Menu PRÊT
		JMenu menuPret = new JMenu("Prêt");
		menuToolBar.add(menuPret);

		// ----- Itens Menu PRET
		JMenuItem itemNewPret = new JMenuItem("Prêt et Retour");
		itemNewPret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pret.setVisible(true);
			}
		});
		menuPret.add(itemNewPret);
		//==================================================
		// ***** Menu FILE D'ATTENTE
		JMenu menuFile = new JMenu("File d'attente");
		menuToolBar.add(menuFile);

		// ----- Itens Menu FILE
		JMenuItem itemVoirFile = new JMenuItem("Voir file");
		itemVoirFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileAttente.frameNewFileAttente.setVisible(true);
			}
		});
		menuFile.add(itemVoirFile);
		//==================================================
		// ***** Menu RETARD
		JMenu menuRetard = new JMenu("Retard");
		menuToolBar.add(menuRetard);

		// ----- Itens Menu RETARD
		JMenuItem itemVoirRetard = new JMenuItem("Voir retard");
		itemVoirRetard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retard.setVisible(true);
			}
		});
		menuRetard.add(itemVoirRetard);
	}
	//==================================================
	private void fieldsOfSearching() {
		// -------------------------------
		// ***** Label RECHERCHER
		JLabel lblRechercher = new JLabel("RECHERCHER");
		lblRechercher.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblRechercher.setBounds(251, 32, 195, 26);
		frame.getContentPane().add(lblRechercher);
		// ***** Field Title
		JLabel lblTitle = new JLabel("TITRE :");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(49, 82, 164, 21);
		frame.getContentPane().add(lblTitle);
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(167, 83, 430, 22);
		frame.getContentPane().add(textFieldTitle);
		textFieldTitle.setColumns(10);
		// -------------------------------
		// ***** Field ISBN
		JLabel lblISBN = new JLabel("ISBN :");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblISBN.setBounds(49, 126, 164, 21);
		frame.getContentPane().add(lblISBN);
		textFieldISBN = new JTextField();
		textFieldISBN.setColumns(10);
		textFieldISBN.setBounds(167, 127, 430, 22);
		frame.getContentPane().add(textFieldISBN);
		// -------------------------------
		// ***** Field Author
		JLabel lblAuthor = new JLabel("AUTEUR :");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuthor.setBounds(49, 172, 164, 21);
		frame.getContentPane().add(lblAuthor);
		textFieldAuthor = new JTextField();
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(167, 173, 430, 22);
		frame.getContentPane().add(textFieldAuthor);
		// -------------------------------
		// ***** Combo Genre
		JLabel lblGenre = new JLabel("GENRE :");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenre.setBounds(49, 217, 164, 21);
		frame.getContentPane().add(lblGenre);
		comboBoxGenre = new JComboBox();
		comboBoxGenre.setBounds(167, 219, 260, 20);
		frame.getContentPane().add(comboBoxGenre);
		String selectComboValues = "SELECT DISTINCT genre FROM genre ORDER BY genre ASC";
		createCombo(comboBoxGenre, selectComboValues);
		// -------------------------------
		// ***** Combo Editor
		JLabel lblEditor = new JLabel("EDITEUR :");
		lblEditor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEditor.setBounds(49, 262, 164, 21);
		frame.getContentPane().add(lblEditor);
		comboBoxEditor = new JComboBox();
		comboBoxEditor.setBounds(167, 264, 260, 20);
		frame.getContentPane().add(comboBoxEditor);
		selectComboValues = "SELECT DISTINCT editeur FROM editeur ORDER BY editeur ASC";
		createCombo(comboBoxEditor, selectComboValues);
		// -------------------------------
		// ***** Combo Language
		JLabel lblLanguage = new JLabel("LANGUE :");
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLanguage.setBounds(49, 308, 164, 21);
		frame.getContentPane().add(lblLanguage);
		comboBoxLanguage = new JComboBox();
		comboBoxLanguage.setBounds(167, 310, 260, 20);
		frame.getContentPane().add(comboBoxLanguage);
		selectComboValues = "SELECT DISTINCT langue FROM langue ORDER BY langue ASC";
		createCombo(comboBoxLanguage, selectComboValues);
		// -------------------------------
		// ***** Checkbox Rare
		JLabel lblRare = new JLabel("RARE :");
		lblRare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRare.setBounds(49, 353, 80, 21);
		frame.getContentPane().add(lblRare);
		chbxRare = new JCheckBox("");
		chbxRare.setBounds(167, 353, 97, 23);
		frame.getContentPane().add(chbxRare);
		// -------------------------------
		// ***** Label Published Date
		JLabel lblPublication = new JLabel("PUBLICATION :");
		lblPublication.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPublication.setBounds(49, 397, 133, 21);
		frame.getContentPane().add(lblPublication);
		lblPublishedDate = new JLabel("");
		lblPublishedDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPublishedDate.setBounds(167, 397, 260, 21);
		frame.getContentPane().add(lblPublishedDate);
		// -------------------------------
		// ***** Label Address
		JLabel lblAdresse = new JLabel("ADRESSE :");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresse.setBounds(49, 435, 133, 21);
		frame.getContentPane().add(lblAdresse);
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(167, 435, 260, 21);
		frame.getContentPane().add(lblAddress);
		// -------------------------------
		// ***** Label Num_Exemplaire
		JLabel lblExemplaire = new JLabel("EXEMPLAIRE :");
		lblExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExemplaire.setBounds(49, 476, 133, 21);
		frame.getContentPane().add(lblExemplaire);
		lblNumExemplaire = 
				new JLabel("");
		lblNumExemplaire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumExemplaire.setBounds(167, 476, 260, 21);
		frame.getContentPane().add(lblNumExemplaire);
	}

	//==================================================
	private void searchButton() {
		// ***** Button RECHERCHER
		btnRechercher = new JButton("RECHERCHER");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(textFieldISBN.getText().length() == 0 && textFieldISBN.getText().length() == 0 && textFieldTitle.getText().length() == 0 &&
						textFieldAuthor.getText().length() == 0 && comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") &&
						comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") && comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")){
					JOptionPane.showMessageDialog(null, "Aucune valeur a été entré pour faire la recherche!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String selectQuery = "";
					// ***** Search by Title
					if (textFieldTitle.getText().length() > 0) {
						selectQuery = "SELECT * FROM livreinfo WHERE titre LIKE '%" + textFieldTitle.getText() + "%'";
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
						selectQuery = "SELECT * FROM livreinfo WHERE isbn LIKE '%" + textFieldISBN.getText() + "%'";
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
						selectQuery = "SELECT * FROM livreinfo WHERE auteur LIKE '%" + textFieldAuthor.getText() + "%'";
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
						selectQuery = "SELECT * FROM livreinfo WHERE genre = '" + comboBoxGenre.getSelectedItem().toString() + "'";
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
						selectQuery = "SELECT * FROM livreinfo WHERE editeur = '" + comboBoxEditor.getSelectedItem().toString() + "'";
						if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
							selectQuery += " AND langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
						}
						if (chbxRare.isSelected()){
							selectQuery += " AND rare = 1";
						}
					}
					// ***** Search by Language
					else if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ) {
						selectQuery = "SELECT * FROM livreinfo WHERE langue = '" + comboBoxLanguage.getSelectedItem().toString() + "'";
						if (chbxRare.isSelected()){
							selectQuery += " AND rare = 1";
						}
					}
					// ***** Search by Rare
					else if (chbxRare.isSelected()) {
						selectQuery = "SELECT * FROM livreinfo WHERE rare = 1";
					}
					findBook(selectQuery);
				}

			}
		});
		btnRechercher.setBounds(479, 536, 118, 23);
		frame.getContentPane().add(btnRechercher);

		btnEffacerLivre = new JButton("EFFACER LIVRE");
		btnEffacerLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete from livre_exemplaire
				String deleteQuery = "DELETE FROM livre_exemplaire WHERE isbn = '" + textFieldISBN.getText() + "'";
				deleteQuery(deleteQuery);

				int id_livre_titre_auteur = find_id_livreTitreAuteur(textFieldISBN.getText());

				// delete from livre
				deleteQuery = "DELETE FROM livre WHERE isbn = '" + textFieldISBN.getText() + "'";
				deleteQuery(deleteQuery);

				// delete from livre_exemplaire
				deleteQuery = "DELETE FROM livre_titre_auteur WHERE id_livreTitreAuteur = '" + String.valueOf(id_livre_titre_auteur) + "'";
				deleteQuery(deleteQuery);
				
				JOptionPane.showMessageDialog(null, "Le livre a été éffacé de la base de données!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEffacerLivre.setBounds(167, 536, 144, 23);
		frame.getContentPane().add(btnEffacerLivre);

		btnEffacerChamps = new JButton("EFFACER CHAMPS");
		btnEffacerChamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTitle.setText("");
				textFieldISBN.setText("");
				textFieldAuthor.setText("");
				comboBoxGenre.setSelectedItem("-- SÉLÉCTIONNER --");
				comboBoxEditor.setSelectedItem("-- SÉLÉCTIONNER --");
				comboBoxLanguage.setSelectedItem("-- SÉLÉCTIONNER --");
				chbxRare.setSelected(false);
				lblPublishedDate.setText("");
				lblAddress.setText("");
				lblNumExemplaire.setText("");
				btnEffacerChamps.setVisible(false);
				btnEffacerLivre.setVisible(false);
				btnRechercher.setVisible(true);
			}
		});
		btnEffacerChamps.setBounds(447, 536, 150, 23);
		frame.getContentPane().add(btnEffacerChamps);

		btnEffacerLivre.setVisible(false);
		btnEffacerChamps.setVisible(false);
	}
	//==================================================
	private void createCombo(JComboBox combo, String query) {
		try{
			combo.addItem("-- SÉLÉCTIONNER --");

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
	//==================================================
	private void findBook(String query) {

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

			ResultSet rs = stmt.executeQuery(query);

			//JTable table = new JTable(buildTableModel(rs));
			//JOptionPane.showMessageDialog(null, new JScrollPane(table));


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

			String loadSelectedBook = "SELECT * FROM livreinfo WHERE isbn = '" + tm.getValueAt(table.getSelectedRows()[0],0)+ "'";
			rs = stmt.executeQuery(loadSelectedBook);
			if (rs.next()){

				textFieldTitle.setText(rs.getString("titre"));
				textFieldISBN.setText(rs.getString("isbn"));
				textFieldAuthor.setText(rs.getString("auteur"));
				comboBoxGenre.setSelectedItem(rs.getString("genre"));
				comboBoxEditor.setSelectedItem(rs.getString("editeur"));
				comboBoxLanguage.setSelectedItem(rs.getString("langue"));
				chbxRare.setSelected(rs.getBoolean("rare"));
				lblPublishedDate.setText(rs.getString("dtPublication"));
				lblAddress.setText(rs.getString("adresse_ex"));
				lblNumExemplaire.setText(rs.getString("num_exemplaire"));
			}

			btnRechercher.setVisible(false);
			btnEffacerLivre.setVisible(true);
			btnEffacerChamps.setVisible(true);

			rs.close();
			stmt.close();
			con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//==================================================
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		System.out.println(rs);
		ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
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
	//==================================================
	private void deleteQuery(String query) {
		try{
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/biblio";
			Connection con = DriverManager.getConnection(url, "root", "root");

			//====================================
			/*System.out.println("URL: " + url);
			System.out.println("Connection: " + con);*/
			//====================================

			con.setAutoCommit(false);
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate(query);

			stmt.close();
			con.commit();
			con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//==================================================
	private int find_id_livreTitreAuteur(String isbn) {
		int id = 0;
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
	//==================================================
}
//==================================================
