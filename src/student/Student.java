package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textFieldAnswer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(33, 34, 130, 26);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(243, 34, 130, 26);
		frame.getContentPane().add(textField2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int number1 = Integer.parseInt(textField1.getText());
				int number2 = Integer.parseInt(textField2.getText());
				int ans = number1 + number2; 
				
				textFieldAnswer.setText(Integer.toString(ans));
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(33, 94, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int number1 = Integer.parseInt(textField1.getText());
					int number2 = Integer.parseInt(textField2.getText());
					int ans = number1 - number2; 
					
					textFieldAnswer.setText(Integer.toString(ans));
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Please enter a valid number");
					}
			}
		});
		btnSubtract.setBounds(256, 94, 117, 29);
		frame.getContentPane().add(btnSubtract);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(181, 206, 130, 26);
		frame.getContentPane().add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Answer");
		lblNewLabel.setBounds(104, 211, 61, 16);
		frame.getContentPane().add(lblNewLabel);
	}
}
