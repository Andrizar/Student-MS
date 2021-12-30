package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class Marks extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField search;
	private JLabel lblFirstName;
	private JTextField fName;
	private JLabel lblLastName;
	private JLabel lblRegNo;
	private JLabel lblClass;
	private JTextField lName;
	private JTextField regNo;
	private JTextField marks;
	private JLabel lblSubject;
	private JTextField subject;
	private JTextField ID;
	private JLabel LABELID;
	private JButton btnHome;
	private JButton btnLogout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudents frame = new ViewStudents();
					frame.setVisible(true);
					con = DBConnect.connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void tableRefresh() {
		try {
			String query = "SELECT id,FirstName,LastName,regNo,gender,age,subject,class FROM students";
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
		setBounds(100, 100, 832, 605);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoad = new JButton("View All");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT id,FirstName,LastName,regNo,gender,age,subject,class FROM students";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
//					table.getColumn(0).setMaxWidth(0);
//					table.getColumn(0).setMinWidth(0);
				}
				catch(Exception e) {
					
				}
			}
		});
		btnLoad.setBounds(438, 94, 89, 39);
		contentPane.add(btnLoad);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(10, 156, 515, 399);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String RegNo = ((table.getModel().getValueAt(row, 3).toString()));
					String query = "SELECT * FROM students WHERE regNo='"+RegNo+"'";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						ID.setText((table.getModel().getValueAt(row, 0).toString()));
						fName.setText((table.getModel().getValueAt(row, 1).toString()));
						lName.setText((table.getModel().getValueAt(row, 2).toString()));
						regNo.setText((table.getModel().getValueAt(row, 3).toString()));
						subject.setText((table.getModel().getValueAt(row, 6).toString()));
						marks.setText((table.getModel().getValueAt(row, 7).toString()));	
					}
					ps.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String Search = search.getText();
					
//					System.out.println(criteria);
//					System.out.println(comboBox.getSelectedItem().toString());
					
//					if(criteria!=null) {
//						System.out.println(criteria);
//					JOptionPane.showMessageDialog(null, criteria);
//					}
					String query = "SELECT * FROM students WHERE ? LIKE ?";
					PreparedStatement ps = con.prepareStatement(query);
//					ps.setString(1, criteria);
					ps.setString(2,"'"+Search+"%'");
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		search.setBounds(217, 94, 199, 38);
		contentPane.add(search);
		search.setColumns(10);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(535, 180, 57, 14);
		contentPane.add(lblFirstName);
		
		fName = new JTextField();
		fName.setBounds(602, 177, 175, 20);
		contentPane.add(fName);
		fName.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(542, 224, 50, 14);
		contentPane.add(lblLastName);
		
		lblRegNo = new JLabel("Reg No");
		lblRegNo.setBounds(557, 266, 35, 14);
		contentPane.add(lblRegNo);
		
		lblClass = new JLabel("Class");
		lblClass.setBounds(568, 360, 35, 14);
		contentPane.add(lblClass);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(602, 221, 175, 20);
		contentPane.add(lName);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(602, 263, 175, 20);
		contentPane.add(regNo);
		
		marks = new JTextField();
		marks.setColumns(10);
		marks.setBounds(602, 357, 175, 20);
		contentPane.add(marks);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					PreparedStatement ps = con.prepareStatement("INSERT INTO students(firstName,lastName,regNo,gender,age,subject,class) VALUES(?,?,?,?,?,?,?)");
					ps.setString(1, fName.getText());
					ps.setString(2, lName.getText());
					ps.setString(3, regNo.getText());
					ps.setString(4, subject.getText());
					ps.setString(5, marks.getText());
					if(ps.executeUpdate()==1) {
						fName.setText("");
						lName.setText("");
						regNo.setText("");
						subject.setText("");
						marks.setText("");
						
						JOptionPane.showMessageDialog(null, "Student Registered successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				tableRefresh();
		
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(535, 487, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps = con.prepareStatement("UPDATE students SET firstName=?,lastName=?,regNo=?,gender=?,age=?,subject=?,class=? WHERE id=?");
					ps.setString(1, fName.getText());
					ps.setString(2, lName.getText());
					ps.setString(3, regNo.getText());
					ps.setString(4, subject.getText());
					ps.setString(5, marks.getText());
					int id = Integer.parseInt(ID.getText());
					ps.setInt(8,id);
					
					
					if(ps.executeUpdate()==1) {
						tableRefresh();
						JOptionPane.showMessageDialog(null, "Student Information Updated successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBackground(Color.BLUE);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBounds(637, 487, 80, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
					int id = Integer.parseInt(ID.getText());
					ps.setInt(1,id);
					
					
					if(ps.executeUpdate()==1) {
						tableRefresh();
						JOptionPane.showMessageDialog(null, "Student Information DELETED successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(727, 487, 80, 23);
		contentPane.add(btnDelete);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(556, 309, 36, 14);
		contentPane.add(lblSubject);
		
		subject = new JTextField();
		subject.setColumns(10);
		subject.setBounds(602, 306, 175, 20);
		contentPane.add(subject);
		
		ID = new JTextField();
		ID.setBounds(602, 146, 175, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		LABELID = new JLabel("id");
		LABELID.setBounds(567, 149, 16, 14);
		contentPane.add(LABELID);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Home h = new Home();
				h.setVisible(true);
			}
		});
		btnHome.setBounds(10, 11, 89, 23);
		contentPane.add(btnHome);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(706, 11, 89, 23);
		contentPane.add(btnLogout);
		String column[]={"ID","NAME","SALARY"};
	}
}
