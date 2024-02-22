package bhanu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Registration {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 589);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(54, 51, 122, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(54, 137, 122, 47);
		frame.getContentPane().add(lblName);
		
		JLabel lblMarks = new JLabel("marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMarks.setBounds(54, 236, 122, 47);
		frame.getContentPane().add(lblMarks);
		
		tf1 = new JTextField();
		tf1.setBounds(132, 63, 155, 30);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(132, 154, 155, 30);
		frame.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(132, 253, 155, 30);
		frame.getContentPane().add(tf3);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =Integer.parseInt(tf1.getText());
				String name =tf2.getText();
				int marks =Integer.parseInt(tf3.getText());
				try {
					//loading driver
					Class.forName("com.mysql.jdbc.Driver");
					//connection establish
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","mrec");
					//creating statement
					PreparedStatement st=con.prepareStatement("insert into studentdetails values(?,?,?)");
					st.setInt(1,id);
					st.setString(2,name);
					st.setInt(3, marks);
					st.executeUpdate();
					
				} catch(Exception e1) {
					e1.printStackTrace();
					
				}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(102, 366, 155, 41);
		frame.getContentPane().add(btnNewButton);
	}

}
