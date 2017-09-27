package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SequenceCreateDB extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SequenceCreateDB frame = new SequenceCreateDB();
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
	public SequenceCreateDB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CreateDB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreateDB.createDB();
				System.out.println("CreateDB");
			}
		});
		btnNewButton.setBounds(53, 111, 300, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCreatetables = new JButton("CreateTables");
		btnCreatetables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateTables.createTables();
				System.out.println("CreateTables");
			}
		});
		btnCreatetables.setBounds(53, 145, 300, 23);
		contentPane.add(btnCreatetables);
		
		JButton btnInsertrowsauteur = new JButton("InsertRowsAuteur");
		btnInsertrowsauteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsAuteur.insertRowsAuteur();
				System.out.println("InsertRowsAuteur");
			}
		});
		btnInsertrowsauteur.setBounds(53, 213, 300, 23);
		contentPane.add(btnInsertrowsauteur);
		
		JButton btnInsertrowsclient = new JButton("InsertRowsClient");
		btnInsertrowsclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsClient.insertRowsClient();
				System.out.println("InsertRowsClient");
			}
		});
		btnInsertrowsclient.setBounds(53, 179, 300, 23);
		contentPane.add(btnInsertrowsclient);
		
		JButton btnInsertrowsediteur = new JButton("InsertRowsEditeur");
		btnInsertrowsediteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsEditeur.insertRowsEditeur();
				System.out.println("InsertRowsEditeur");
			}
		});
		btnInsertrowsediteur.setBounds(53, 247, 300, 23);
		contentPane.add(btnInsertrowsediteur);
		
		JButton btnInsertrowsgenre = new JButton("InsertRowsGenre");
		btnInsertrowsgenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsGenre.insertRowsGenre();
				System.out.println("InsertRowsGenre");
			}
		});
		btnInsertrowsgenre.setBounds(53, 281, 300, 23);
		contentPane.add(btnInsertrowsgenre);
		
		JButton btnInsertrowslangue = new JButton("InsertRowsLangue");
		btnInsertrowslangue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsLangue.insertRowsLangue();
				System.out.println("InsertRowsLangue");				
			}
		});
		btnInsertrowslangue.setBounds(53, 315, 300, 23);
		contentPane.add(btnInsertrowslangue);
		
		JButton button = new JButton("InsertRowsLivre");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsLivre.insertRowsLivre();
				System.out.println("InsertRowsLivre");
			}
		});
		button.setBounds(53, 417, 300, 23);
		contentPane.add(button);
		
		JButton btnInsertrowslivreexemplaire = new JButton("InsertRowsLivreExemplaire");
		btnInsertrowslivreexemplaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsLivreExemplaire.insertRowsLivreExemplaire();
				System.out.println("InsertRowsLivreExemplaire");	
			}
		});
		btnInsertrowslivreexemplaire.setBounds(53, 451, 300, 23);
		contentPane.add(btnInsertrowslivreexemplaire);
		
		JButton btnInsertrowslivretitreauteur = new JButton("InsertRowsLivreTitreAuteur");
		btnInsertrowslivretitreauteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsLivreTitreAuteur.insertRowsLivreTitreAuteur();
				System.out.println("InsertRowsLivreTitreAuteur");				
			}
		});
		btnInsertrowslivretitreauteur.setBounds(53, 383, 300, 23);
		contentPane.add(btnInsertrowslivretitreauteur);
		
		JButton btnInsertrowstitre = new JButton("InsertRowsTitre");
		btnInsertrowstitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InsertRowsTitre.insertRowsTitre();
				System.out.println("InsertRowsTitre");				
			}
		});
		btnInsertrowstitre.setBounds(53, 349, 300, 23);
		contentPane.add(btnInsertrowstitre);
		
		JLabel lblSquenceDeCration = new JLabel("S\u00E9quence de cr\u00E9ation de la base des donn\u00E9es");
		lblSquenceDeCration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSquenceDeCration.setBounds(51, 39, 326, 39);
		contentPane.add(lblSquenceDeCration);
		
		JButton btnCreateviews = new JButton("CreateViews");
		btnCreateviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateViews.createViews();
				System.out.println("CreateViews");
			}
		});
		btnCreateviews.setBounds(53, 485, 300, 23);
		contentPane.add(btnCreateviews);
	}
}







