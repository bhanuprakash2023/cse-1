package bhanu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signdetails {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JPasswordField pw2;
	private JPasswordField pw1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signdetails window = new signdetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signdetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 752, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("signup");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(110, 59, 102, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel us1 = new JLabel("username");
		us1.setFont(new Font("Tahoma", Font.BOLD, 20));
		us1.setBounds(33, 122, 102, 35);
		frame.getContentPane().add(us1);
		
		JLabel lblPassward = new JLabel("passward");
		lblPassward.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassward.setBounds(33, 204, 102, 35);
		frame.getContentPane().add(lblPassward);
		
		tf1 = new JTextField();
		tf1.setBounds(162, 134, 162, 23);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JLabel lblSignin = new JLabel("signin");
		lblSignin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSignin.setBounds(502, 59, 102, 35);
		frame.getContentPane().add(lblSignin);
		
		JLabel us2 = new JLabel("username");
		us2.setFont(new Font("Tahoma", Font.BOLD, 20));
		us2.setBounds(401, 122, 102, 35);
		frame.getContentPane().add(us2);
		
		JLabel lblPassward_1 = new JLabel("passward");
		lblPassward_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassward_1.setBounds(401, 204, 102, 35);
		frame.getContentPane().add(lblPassward_1);
		
		tf2 = new JTextField();
		tf2.setBounds(540, 126, 147, 23);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		pw2 = new JPasswordField();
		pw2.setBounds(555, 214, 147, 25);
		frame.getContentPane().add(pw2);
		
		pw1 = new JPasswordField();
		pw1.setBounds(162, 216, 147, 25);
		frame.getContentPane().add(pw1);
		
		JButton su = new JButton("signup");
		su.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =tf1.getText();
				String passward=pw1.getText();
				try {
					//loading driver
					Class.forName("com.mysql.jdbc.Driver");
					//connection establish
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","mrec");
					//creating statement
					PreparedStatement st=con.prepareStatement("insert into signdetails values(?,?)");
					st.setString(1,username);
					st.setString(2,passward);
					st.executeUpdate();
					
				} catch(Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		su.setFont(new Font("Tahoma", Font.BOLD, 18));
		su.setBounds(54, 291, 140, 35);
		frame.getContentPane().add(su);
		
		JButton btnSignin = new JButton("signin");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tf2.getText();
				String password = pw2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","mrec");
					Statement st =con.createStatement();
					ResultSet rs = st.executeQuery("select passward from signdetails where username = '"+username+"'");
					rs.next();
					String pass = rs.getString(1);
					if(pass.equals(password)) {
						JOptionPane.showMessageDialog(btnSignin," signin done");
						return;
						}
					JOptionPane.showMessageDialog(btnSignin, "invalid signin");
						
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
					
			}
		});
		btnSignin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignin.setBounds(547, 291, 140, 35);
		frame.getContentPane().add(btnSignin);
	}
}
