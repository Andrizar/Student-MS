package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;

public class Marks2 extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static Connection con = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks2 frame = new Marks2();
					frame.setVisible(true);
					 con = DBConnect.connect();
					 tableRefresh();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void tableRefresh() {
		try {
//			String query = "SELECT sID,FirstName,LastName,regNo,gender,age,class FROM students";
			String query = "Select students.FirstName, students.LastName, students.regNo, marks.mark, marks.GRADE, subject.subjectName FROM students INNER JOIN marks ON students.sID=marks.sID INNER JOIN subject ON marks.subjectID=subject.subjectID";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(Exception e) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public Marks2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(95, 81, 521, 336);
		contentPane.add(table);
	}
}
