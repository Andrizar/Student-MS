package student;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	public static Connection con = null;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
//		try {
//			con = DBConnect.connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					con = DBConnect.connect();
					

//					Home home = new Home();
				
					  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setBounds(281, 21, 76, 16);
		frame.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(261, 83, 220, 26);
		frame.getContentPane().add(username);
		JButton btnLogin = new JButton("Login");
		username.setColumns(10);
//		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username!=null) {
					frame.dispose();
//					frame.setVisible(false);
					Home h = new Home();
//					h.setTitle("Home");
//					h.setBounds(100, 100, 477, 517);
//					h.setVisible(true);
//					new Registration().s
//					new Student().
//					h.setVisible(true);
				}
//				Home home = new Home();   
//		        setVisible(false); // Hide current frame
//		        home.setVisible(true);
//				if (e.getSource() == btnLogin) {
//					frame.dispose();
////					Home home = new Home();
////					home.super.setVisible(true);
//					new Home();
//
//            }
				
			}
		});
		
//		
//		btnLogin.addActionListener(new ActionListener() {
//			String userName;
//			char[] pass;
//			public void actionPerformed(ActionEvent e) {
//				
//				if(e.getSource()== btnLogin) {
//						
//						
//						frame.dispose();
//						
//				}
//				ResultSet rs;
//				try {
//					userName = username.getText();
//					pass = password.getPassword();
//					Statement st = con.createStatement();
//					rs = st.executeQuery("SELECT * FROM users WHERE username='"+userName+"'");
//					if(rs.next()) {
//						frame.dispose();
////						new Registration()
//						
//						}
//					else {
//						System.out.println("No");
//					}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//		 private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) { 
//		        Home jfrm2= new Home();
//		        jfrm2.setSize(270, 160); 
//		        jfrm2.setVisible(true);
//		        this.setVisible(false);
//		        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//		        this.dispose();
//		    } 
		
		
		btnLogin.setBounds(393, 188, 88, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(186, 88, 76, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(188, 155, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(261, 150, 220, 26);
		frame.getContentPane().add(password);
	}

}
