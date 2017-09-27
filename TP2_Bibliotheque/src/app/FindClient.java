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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class FindClient extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Recherche;
	private JComboBox comboBoxCritRecherche;
	public int cbCritere = 0;
	private JTextField tf_IdClient;
	private JTextField tf_Prenom;
	private JTextField tf_Nom;

	static FindClient frameFindClient = new FindClient();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindClient frame = new FindClient();
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
	public FindClient() {

		
		
		//  ----------------------------- LABELS ET TEXTFIELDS -----------------------------

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Recherche d'un abonn\u00E9");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(24, 53, 244, 14);
		contentPane.add(label);

		tf_Recherche = new JTextField();
		tf_Recherche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Recherche.setColumns(10);
		tf_Recherche.setBounds(24, 80, 509, 20);
		contentPane.add(tf_Recherche);

		JLabel label_1 = new JLabel("Crit\u00E8re de recherche");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(24, 125, 194, 14);
		contentPane.add(label_1);

		JLabel lblNom = new JLabel("Code d'identification");
		lblNom.setBounds(24, 212, 182, 14);
		contentPane.add(lblNom);

		tf_IdClient = new JTextField();
		tf_IdClient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_IdClient.setEditable(false);
		tf_IdClient.setBounds(24, 226, 117, 20);
		contentPane.add(tf_IdClient);
		tf_IdClient.setColumns(10);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(286, 257, 46, 14);
		contentPane.add(lblPrenom);

		tf_Prenom = new JTextField();
		tf_Prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Prenom.setEditable(false);
		tf_Prenom.setColumns(10);
		tf_Prenom.setBounds(286, 271, 260, 20);
		contentPane.add(tf_Prenom);

		JLabel lblNom_1 = new JLabel("Nom");
		lblNom_1.setBounds(24, 257, 46, 14);
		contentPane.add(lblNom_1);

		tf_Nom = new JTextField();
		tf_Nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_Nom.setEditable(false);
		tf_Nom.setColumns(10);
		tf_Nom.setBounds(24, 271, 260, 20);
		contentPane.add(tf_Nom);

		//  ----------------------------- COMBO BOX -----------------------------

		comboBoxCritRecherche = new JComboBox();
		comboBoxCritRecherche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCritRecherche.setModel(new DefaultComboBoxModel(new String[] {
				"-- Critère --", "  Code d'identification", "  Nom", "  Prenom"}));
		comboBoxCritRecherche.setBounds(256, 122, 277, 20);
		contentPane.add(comboBoxCritRecherche);

		//  ----------------------------- BOUTONS -----------------------------

		JButton btRechercher = new JButton("Rechercher");
		btRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nom = tf_Recherche.getText();
				findClient(nom);
			}
		});
		btRechercher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btRechercher.setBounds(383, 167, 150, 23);
		contentPane.add(btRechercher);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				
				//FileAttente.tf_Nom.setText(tf_Nom.getText());
				FileAttente.frameNewFileAttente.tf_Nom.setText(tf_Nom.getText());
				FileAttente.frameNewFileAttente.tf_Prenom.setText(tf_Prenom.getText());
				FileAttente.frameNewFileAttente.tf_IdClient.setText(tf_IdClient.getText());
				
				NewPret.tf_Nom.setText(tf_Nom.getText());				
				NewPret.tf_Prenom.setText(tf_Prenom.getText());
				NewPret.tf_IdClient.setText(tf_IdClient.getText());
				
				//FileAttente w = new FileAttente();
				//w.setVisible(true);
				
				effacherChamps();
				setVisible(false);			
			}
		});
		btnOk.setBounds(457, 309, 89, 23);
		contentPane.add(btnOk);
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

	public static int optionRecherche = 1;
	
	// Fonction pour chercher client et completer la table avec les resultats de la recherche
	private void findClient(String nom) {

		System.out.println(optionRecherche);
		
		cbCritere = comboBoxCritRecherche.getSelectedIndex();
		//System.out.println(cbCritere);
		String critereRecherche = "";

		
			if (cbCritere == 1) {
				critereRecherche = "SELECT * FROM client WHERE id_client LIKE '%" + tf_Recherche.getText() + "%';"; 
			}
			else if (cbCritere == 2) {
				critereRecherche = "SELECT * FROM client WHERE nom LIKE '%" + tf_Recherche.getText() + "%';"; 
			}
			else if (cbCritere == 3) {
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

	public void effacherChamps() {
		
		tf_Nom.setText("");
		tf_Prenom.setText("");
		tf_IdClient.setText("");
		tf_Recherche.setText("");
		comboBoxCritRecherche.setSelectedIndex(0);
		
	}



}
