package app;
//==================================================
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
//==================================================
public class NewBook extends JFrame {
	//==================================================
	private JPanel contentPane;
	private JTextField textFieldISBN;
	private JLabel titre;
	private JLabel isbn;
	private JLabel auteur;
	private JLabel genre;
	private JLabel editeur;
	private JLabel langue;
	private JLabel rare;
	private JCheckBox checkBoxRare;
	public JComboBox comboBoxTitle;
	private JComboBox comboBoxAuthor;
	private JComboBox comboBoxGenre;
	private JComboBox comboBoxEditor;
	private JComboBox comboBoxLanguage;
	static NewBook frameNewBook = new NewBook();
	private JLabel lblDtPub;
	private JTextField textFieldPublishedDate;
	private JLabel lblAdresse;
	private JTextField textFieldAddress;
	//==================================================
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frameNewBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//==================================================
	public NewBook() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Livre");
		setBounds(100, 100, 930, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		createLabels();
		createFieldsAndCombos();
		createButtons();
		fillCombo();

	}
	//==================================================
	private void createLabels() {
		contentPane.setLayout(null);
		JLabel lblNouveauLivre = new JLabel("NOUVEAU LIVRE");
		lblNouveauLivre.setBounds(352, 11, 266, 43);
		lblNouveauLivre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouveauLivre.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNouveauLivre);

		titre = new JLabel("TITRE");
		titre.setBounds(33, 121, 51, 21);
		titre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(titre);

		isbn = new JLabel("ISBN");
		isbn.setBounds(33, 76, 164, 21);
		isbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(isbn);

		auteur = new JLabel("AUTEUR");
		auteur.setBounds(33, 169, 164, 21);
		auteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(auteur);

		genre = new JLabel("GENRE");
		genre.setBounds(33, 228, 164, 21);
		genre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(genre);

		editeur = new JLabel("EDITEUR");
		editeur.setBounds(33, 274, 164, 21);
		editeur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(editeur);

		langue = new JLabel("LANGUE");
		langue.setBounds(33, 323, 164, 21);
		langue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(langue);

		rare = new JLabel("RARE");
		rare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rare.setBounds(33, 478, 80, 21);
		contentPane.add(rare);

		lblDtPub = new JLabel("DATA PUBLICATION");
		lblDtPub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDtPub.setBounds(33, 380, 164, 21);
		contentPane.add(lblDtPub);

		lblAdresse = new JLabel("ADRESSE");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresse.setBounds(33, 431, 164, 21);
		contentPane.add(lblAdresse);
	}
	//==================================================
	public void createFieldsAndCombos() {
		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(207, 76, 246, 20);
		contentPane.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		comboBoxTitle = new JComboBox();
		comboBoxTitle.setBounds(207, 121, 458, 20);
		contentPane.add(comboBoxTitle);

		comboBoxAuthor = new JComboBox();
		comboBoxAuthor.setBounds(207, 169, 458, 20);
		contentPane.add(comboBoxAuthor);

		comboBoxGenre = new JComboBox();
		comboBoxGenre.setBounds(207, 228, 458, 20);
		contentPane.add(comboBoxGenre);

		comboBoxEditor = new JComboBox();
		comboBoxEditor.setBounds(207, 274, 458, 20);
		contentPane.add(comboBoxEditor);

		comboBoxLanguage = new JComboBox();
		comboBoxLanguage.setBounds(207, 323, 458, 20);
		contentPane.add(comboBoxLanguage);

		checkBoxRare = new JCheckBox("");
		checkBoxRare.setBounds(207, 478, 97, 23);
		contentPane.add(checkBoxRare);

		textFieldPublishedDate = new JTextField();
		textFieldPublishedDate.setColumns(10);
		textFieldPublishedDate.setBounds(207, 382, 246, 20);
		textFieldPublishedDate.setText("yyyy-mm-dd");
		textFieldPublishedDate.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				textFieldPublishedDate.setText(""); 
			}
			public void focusLost(FocusEvent e) {
			}
		}); 
		contentPane.add(textFieldPublishedDate);

		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(207, 432, 246, 22);
		contentPane.add(textFieldAddress);
	}
	//==================================================
	public void createButtons() {
		JButton btnNewTitle = new JButton("NOUVEAU TITRE");
		btnNewTitle.setBounds(702, 122, 164, 23);
		btnNewTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNewTitle.frameInsertNewTitle.setVisible(true);
				frameNewBook.setVisible(false);
			}
		});
		contentPane.add(btnNewTitle);

		JButton btnNewAuthor = new JButton("NOUVEAU AUTEUR");
		btnNewAuthor.setBounds(702, 170, 164, 23);
		btnNewAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertNewAutor.frameInsertNewAutor.setVisible(true);
				frameNewBook.setVisible(false);
			}
		});
		contentPane.add(btnNewAuthor);

		JButton btnNewGenre = new JButton("NOUVEAU GENRE");
		btnNewGenre.setBounds(698, 229, 168, 23);
		btnNewGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNewGenre.frameInsertNewGenre.setVisible(true);
				frameNewBook.setVisible(false);
			}
		});
		contentPane.add(btnNewGenre);

		JButton btnNewEditor = new JButton("NOUVEL EDITEUR");
		btnNewEditor.setBounds(698, 275, 168, 23);
		btnNewEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNewEditor.frameInsertNewEditor.setVisible(true);
				frameNewBook.setVisible(false);
			}
		});
		contentPane.add(btnNewEditor);

		JButton btnNewLanguage = new JButton("NOUVELLE LANGUE");
		btnNewLanguage.setBounds(698, 324, 168, 23);
		btnNewLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNewLanguage.frameInsertNewLanguage.setVisible(true);
				frameNewBook.setVisible(false);
			}
		});
		contentPane.add(btnNewLanguage);

		// AJOUTER LIVRE
		JButton btnNewButton = new JButton("AJOUTER LIVRE");
		btnNewButton.setBounds(352, 534, 164, 35);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textFieldISBN.getText().length() == 0 || comboBoxTitle.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ||
						comboBoxAuthor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") || comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ||
						comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") || comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --") ||
						textFieldAddress.getText().length() == 0 || textFieldAddress.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "SVP, veiullez remplir tous les champs!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					int id_livre_titre_auteur = defineIdLivreTitreAuteur();
					String insertQuery = "INSERT INTO livre_titre_auteur (id_livreTitreAuteur, id_titre, id_auteur, id_genre) " + "VALUES (" + id_livre_titre_auteur + ", ";
					String tableName = "";
					String selection = "";

					// ***** Insert table livre_titre_auteur
					if (!comboBoxTitle.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")) {
						tableName = titre.getText();
						selection = comboBoxTitle.getSelectedItem().toString();
						insertQuery += getId(tableName, selection) + ", ";
					}
					if (!comboBoxAuthor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")) {
						tableName = auteur.getText();
						selection = comboBoxAuthor.getSelectedItem().toString();
						insertQuery += getId(tableName, selection) + ", ";
					}
					if (!comboBoxGenre.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")) {
						tableName = genre.getText();
						selection = comboBoxGenre.getSelectedItem().toString();
						insertQuery += getId(tableName, selection) + ")";
					}
					System.out.println("insertQuery livre_auteur_editeur= " + insertQuery + "\n");
					insertQueryIntoTable(insertQuery);


					// ***** Insert table livre
					insertQuery = "INSERT INTO livre (isbn, rare, id_editeur,  id_langue, id_livreTitreAuteur) " + "VALUES ('" + textFieldISBN.getText() + "', ";
					tableName = "";
					selection = "";

					if (checkBoxRare.isSelected()) {
						insertQuery += true + ", ";
					} else {
						insertQuery += false + ", ";
					}
					if (!comboBoxEditor.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")) {
						tableName = editeur.getText();
						selection = comboBoxEditor.getSelectedItem().toString();
						insertQuery += getId(tableName, selection) + ", ";
					}
					if (!comboBoxLanguage.getSelectedItem().toString().equals("-- SÉLÉCTIONNER --")) {
						tableName = langue.getText();
						selection = comboBoxLanguage.getSelectedItem().toString();
						insertQuery += getId(tableName, selection) + ", ";
					}

					insertQuery += id_livre_titre_auteur + ")";

					System.out.println("insertQuery livre = " + insertQuery + "\n");
					insertQueryIntoTable(insertQuery);


					// ***** Insert table livre_exemplaire
					insertQuery = "INSERT INTO livre_exemplaire (num_ex, dtPublication, adresse_ex, isbn) " + 
							"VALUES ('" + defineNumExemplaire(textFieldISBN.getText()) + "', '" + textFieldPublishedDate.getText() + "', '" + 
							textFieldAddress.getText() + "', '" + textFieldISBN.getText() + "')";
					System.out.println("insertQuery livre_exemplaire = " + insertQuery + "\n");
					insertQueryIntoTable(insertQuery);
					JOptionPane.showMessageDialog(null, "Le livre a été ajouté dans la base de données!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton);
	}
	//==================================================
	public void fillCombo(){
		// ***** Combo Titre
		String selectComboValues = "SELECT DISTINCT titre FROM titre ORDER BY titre ASC";
		createCombo(comboBoxTitle, selectComboValues);
		// -------------------------------
		// ***** Combo Author
		selectComboValues = "SELECT DISTINCT auteur FROM auteur ORDER BY auteur ASC";
		createCombo(comboBoxAuthor, selectComboValues);
		// -------------------------------
		// ***** Combo Genre
		selectComboValues = "SELECT DISTINCT genre FROM genre ORDER BY genre ASC";
		createCombo(comboBoxGenre, selectComboValues);
		// -------------------------------
		// ***** Combo Editor
		selectComboValues = "SELECT DISTINCT editeur FROM editeur ORDER BY editeur ASC";
		createCombo(comboBoxEditor, selectComboValues);
		// -------------------------------
		// ***** Combo Langue
		selectComboValues = "SELECT DISTINCT langue FROM langue ORDER BY langue ASC";
		createCombo(comboBoxLanguage, selectComboValues);
		// -------------------------------
	}
	//==================================================
	private void createCombo(JComboBox combo, String query) {
		combo.removeAllItems();
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
	private int defineIdLivreTitreAuteur() {
		int idLivreTitreAuteur = 5001;
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

			ResultSet rs = stmt.executeQuery("SELECT DISTINCT id_livreTitreAuteur FROM livre_titre_auteur ORDER BY id_livreTitreAuteur ASC ");

			while(rs.next()){                            
				if(Integer.parseInt(rs.getString(1)) == idLivreTitreAuteur) {
					idLivreTitreAuteur++;
				}
			}

			rs.close();
			stmt.close();
			con.close();

			//System.out.println("ID = " + idLivreTitreAuteur);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return idLivreTitreAuteur;
	}
	//==================================================
	private int getId(String table, String name) {
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

			ResultSet rs = stmt.executeQuery("SELECT id_" + table + " FROM " + table + " WHERE " + table + " = '" + name + "'");

			while(rs.next()){ 
				id = Integer.parseInt(rs.getString(1));
			}

			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("ID = " + id);
		return id;
	}
	//==================================================
	private void insertQueryIntoTable(String query) {
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
	private String defineNumExemplaire(String isbn) {
		String num_ex = "";
		int nombreExemplaire = 0;

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

			ResultSet rs = stmt.executeQuery("SELECT num_ex FROM livre_exemplaire WHERE isbn = '" + isbn + "' ORDER BY num_ex ASC");

			while(rs.next()){  
				System.out.println(rs.getString(1));
				if(rs.getString(1).length() > 0) {
					nombreExemplaire++;
				}
			}

			rs.close();
			stmt.close();
			con.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		if (nombreExemplaire < 10) {
			num_ex = isbn + "/00" + String.valueOf(nombreExemplaire+1);
		}
		else if (nombreExemplaire < 100) {
			num_ex = isbn + "/0" + String.valueOf(nombreExemplaire+1);
		}
		else {
			num_ex = isbn + "/" + String.valueOf(nombreExemplaire+1);
		}

		//System.out.println("QTDE EX = " + nombreExemplaire);
		//System.out.println("num_ex = " + num_ex);
		return num_ex;
	}
	//==================================================
}
//==================================================