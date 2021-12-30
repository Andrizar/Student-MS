package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddStudent = new JButton("Students");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAddStudent) {
				contentPane.setVisible(false);
//				frame.dispose();
//				frame.setVisible(false);
				ViewStudents vs = new ViewStudents();
                vs.setVisible(true); 
				}
			}
		});
		btnAddStudent.setBounds(97, 137, 288, 55);
		contentPane.add(btnAddStudent);
		
		JButton btnStudentMarks = new JButton("Student Marks");
		btnStudentMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAddStudent) {
					contentPane.setVisible(false);
//					frame.dispose();
//					frame.setVisible(false);
					Marks m = new Marks();
	                m.setVisible(true); 
					}
			}
		});
		btnStudentMarks.setBounds(97, 219, 288, 55);
		contentPane.add(btnStudentMarks);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(387, 22, 89, 32);
		contentPane.add(btnLogout);
		
		JButton btnTimetable = new JButton("Class Timetable");
		btnTimetable.setBounds(97, 313, 288, 55);
		contentPane.add(btnTimetable);
	}
}
