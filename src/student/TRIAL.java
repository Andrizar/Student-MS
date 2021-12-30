package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TRIAL {

	private JFrame frame;/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		Student s = new Student(fName.getText(),lName.getText(),regNo.getText(),gender.getText(),age.getText(),subject.getText(),Class.getText(),userName.getText(),password.getText());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRIAL window = new TRIAL();
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
	public TRIAL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 548, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
