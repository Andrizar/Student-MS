package student;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registration implements ActionListener{

	private JFrame frame;
	private JTextField fName;
	private JTextField uName;
	private JTextField teacherID;
	private JPasswordField password;
	public static Connection con = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// catching error
		try {
			con = DBConnect.connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		frame.setBounds(100, 100, 636, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher Account Creation Form");
		lblNewLabel.setBounds(251, 28, 304, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(152, 88, 63, 16);
		frame.getContentPane().add(lblFullName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(152, 135, 68, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(152, 182, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblTeacherId = new JLabel("Teacher ID");
		lblTeacherId.setBounds(152, 234, 68, 16);
		frame.getContentPane().add(lblTeacherId);
		
		fName = new JTextField();
		fName.setBounds(232, 83, 244, 26);
		frame.getContentPane().add(fName);
		fName.setColumns(10);
		
		uName = new JTextField();
		uName.setColumns(10);
		uName.setBounds(232, 130, 244, 26);
		frame.getContentPane().add(uName);
		
		teacherID = new JTextField();
		teacherID.setColumns(10);
		teacherID.setBounds(232, 229, 244, 26);
		frame.getContentPane().add(teacherID);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName,userName,tID;
				char[] pass;

				try {
					if(fName!=null && uName!=null && password!=null && teacherID!=null) {
					fullName = fName.getText();
					userName = uName.getText();
					pass = password.getPassword();
					tID = teacherID.getText();
					PreparedStatement ps = con.prepareStatement("INSERT INTO users(name,username,password,teacherID) VALUES('"+fullName+"','"+userName+"','"+pass+"','"+tID+"')");
					if(ps.executeUpdate()==1) {
					JOptionPane.showMessageDialog(null, "Registered successfully");
					}
					}
					else {
						JOptionPane.showMessageDialog(null, "All fields must be filled");
					}
					}
				
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBackground(new Color(0, 255, 0));
		btnRegister.setBounds(359, 280, 117, 29);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("Already have an account?");
		lblNewLabel_1.setBounds(232, 327, 158, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setBounds(397, 327, 41, 16);
		frame.getContentPane().add(lblLogin);
		
		password = new JPasswordField();
		password.setBounds(232, 177, 244, 26);
		frame.getContentPane().add(password);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JLabel lblLogin = new JLabel("Login");
		if(arg0.getSource()==lblLogin) {
			
			frame.dispose();
			Login log = new Login();
			}
	}
}
