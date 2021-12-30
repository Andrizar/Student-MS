package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;

public class Marks extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static Connection con = null;
	private JTextField search;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks frame = new Marks();
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
	public Marks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(95, 81, 521, 336);
		contentPane.add(table);
		
		search = new JTextField();
		search.setBounds(183, 32, 310, 20);
		contentPane.add(search);
		search.setColumns(10);

//		System.out.println(comboBox.getSelectedItem().toString());
		search.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(search.getText().equals("")) {
					tableRefresh();
				}
				else {
						try {
							String query = "Select students.FirstName, students.LastName, students.regNo, marks.mark, marks.GRADE, subject.subjectName FROM students INNER JOIN marks ON students.sID=marks.sID INNER JOIN subject ON marks.subjectID=subject.subjectID " + 
									"WHERE subjectName LIKE '"+search.getText()+"%' OR regNo LIKE '"+search.getText()+"%'";
							PreparedStatement ps = con.prepareStatement(query);
//							ps.setString(1,);
//							ps.setString(1,search.getText()+"%");
							ResultSet rs = ps.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		});
	}
}
