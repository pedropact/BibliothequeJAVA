package app;
//==================================================
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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
//==================================================
public class InsertNewLanguage extends JFrame {
	//==================================================
	private JPanel contentPane;
	private JTextField textFieldLanguage;
	static InsertNewLanguage frameInsertNewLanguage = new InsertNewLanguage();
	//==================================================
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameInsertNewLanguage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//==================================================
	public InsertNewLanguage() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nouvelle Langue");
		setBounds(100, 100, 700, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLanguage = new JLabel("LANGUE :");
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLanguage.setBounds(62, 32, 164, 21);
		contentPane.add(lblLanguage);

		textFieldLanguage = new JTextField();
		textFieldLanguage.setColumns(10);
		textFieldLanguage.setBounds(173, 33, 430, 22);
		contentPane.add(textFieldLanguage);

		JButton btnAdd = new JButton("AJOUTER");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textFieldLanguage.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "SVP, veiullez entrer la langue!", "InfoBox: " + "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String insertQuery = "INSERT INTO langue (id_langue, langue) " + "VALUES (" + defineIdLanguage() + ", '" + textFieldLanguage.getText() + "')";
					System.out.println(insertQuery);
					insertAutor(insertQuery);
					NewBook.frameNewBook.setVisible(true);
					NewBook.frameNewBook.fillCombo();
					InsertNewLanguage.frameInsertNewLanguage.setVisible(false);
				}
			}
		});
		btnAdd.setBounds(283, 83, 112, 33);
		contentPane.add(btnAdd);
	}
	//==================================================
	private void insertAutor(String query) {
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
	private int defineIdLanguage() {
		int idGenre = 101;
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

			ResultSet rs = stmt.executeQuery("SELECT DISTINCT id_langue FROM langue ORDER BY id_langue ASC");

			while(rs.next()){                            
				if(Integer.parseInt(rs.getString(1)) == idGenre) {
					idGenre++;
				}
			}

			rs.close();
			stmt.close();
			con.close();

			System.out.println("ID = " + idGenre);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return idGenre;
	}
	//==================================================
}
//==================================================