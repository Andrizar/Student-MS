package student;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.BorderLayout;

public class ViewStudents1 {

	private JPanel contentPane;
	public static Connection con = null;
	private static JTable table;
	private JTextField search;
	private JTextField ID;
	private JTextField fName;
	private JTextField lName;
	private JTextField regNo;
	private JTextField gender;
	private JTextField age;
	private JTextField classField;
	private JTextField userName;
	private JTextField password;
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
					tableRefresh();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void tableRefresh() {
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
	public ViewStudents() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 462, 393);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		search = new JTextField();
		search.setBounds(10, 64, 193, 26);
		getContentPane().add(search);
		search.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(493, 142, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(493, 179, 51, 14);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(493, 216, 51, 14);
		getContentPane().add(lblLastName);
		
		JLabel lblRegno = new JLabel("regNo");
		lblRegno.setBounds(493, 253, 46, 14);
		getContentPane().add(lblRegno);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(493, 294, 46, 14);
		getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(493, 334, 46, 14);
		getContentPane().add(lblAge);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(493, 370, 46, 14);
		getContentPane().add(lblClass);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(493, 409, 59, 14);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(493, 446, 59, 14);
		getContentPane().add(lblPassword);
		
		ID = new JTextField();
		ID.setBounds(549, 139, 221, 20);
		getContentPane().add(ID);
		ID.setColumns(10);
		
		fName = new JTextField();
		fName.setColumns(10);
		fName.setBounds(549, 176, 221, 20);
		getContentPane().add(fName);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(549, 213, 221, 20);
		getContentPane().add(lName);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(549, 250, 221, 20);
		getContentPane().add(regNo);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(549, 291, 221, 20);
		getContentPane().add(gender);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(549, 328, 221, 20);
		getContentPane().add(age);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(549, 364, 221, 20);
		getContentPane().add(classField);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(549, 403, 221, 20);
		getContentPane().add(userName);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(549, 440, 221, 20);
		getContentPane().add(password);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(482, 498, 89, 23);
		getContentPane().add(btnSave);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(23, 11, 89, 23);
		getContentPane().add(btnHome);
		
		JButton btnLogout = new JButton("Home");
		btnLogout.setBounds(681, 11, 89, 23);
		getContentPane().add(btnLogout);
		
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBounds(548, 485, 89, 23);
		getContentPane().add(btnUpdate_1);
		
		JButton btnHome_4 = new JButton("Home");
		btnHome_4.setBounds(681, 485, 89, 23);
		getContentPane().add(btnHome_4);
		

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
						gender.setText((table.getModel().getValueAt(row, 4).toString()));
						age.setText((table.getModel().getValueAt(row, 5).toString()));
						subject.setText((table.getModel().getValueAt(row, 6).toString()));
						classField.setText((table.getModel().getValueAt(row, 7).toString()));	
					}
					ps.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(46, 102, 149, 23);
		search = new JTextField();
		comboBox.addItem("Search by...");
		comboBox.addItem("subject");
		comboBox.addItem("regNo");
		String criteria = comboBox.getSelectedItem().toString();
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
					ps.setString(1, criteria);
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
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(556, 310, 36, 14);
		contentPane.add(lblGender);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(567, 356, 25, 14);
		contentPane.add(lblAge);
		
		lblClass = new JLabel("Class");
		lblClass.setBounds(568, 438, 35, 14);
		contentPane.add(lblClass);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(602, 221, 175, 20);
		contentPane.add(lName);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(602, 263, 175, 20);
		contentPane.add(regNo);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(602, 307, 175, 20);
		contentPane.add(gender);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(602, 353, 175, 20);
		contentPane.add(age);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(602, 435, 175, 20);
		contentPane.add(classField);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {
					 try {
					StudentDAOImpl sid = new StudentDAOImpl();
//					sid.getConnection();
					Student s = new Student(fName.getText(),lName.getText(),regNo.getText(),gender.getText(),age.getText(),subject.getText(),classField.getText(),userName.getText(),password.getText());	
					sid.addStudent(s);
					fName.setText("");
					lName.setText("");
					regNo.setText("");
					userName.setText("");
					password.setText("");
					gender.setText("");
					age.setText("");
					subject.setText("");
					classField.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					 tableRefresh();
			}
				
		
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(535, 487, 89, 23);
		contentPane.add(btnSave);
		
//		JButton btnUpdate = new JButton("Update");
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					PreparedStatement ps = con.prepareStatement("UPDATE students SET firstName=?,lastName=?,regNo=?,gender=?,age=?,subject=?,class=? WHERE id=?");
//					ps.setString(1, fName.getText());
//					ps.setString(2, lName.getText());
//					ps.setString(3, regNo.getText());
//					ps.setString(4, gender.getText());
//					ps.setString(5, age.getText());
//					ps.setString(6, subject.getText());
//					ps.setString(7, classField.getText());
//					int id = Integer.parseInt(ID.getText());
//					ps.setInt(8,id);
//					
//					if(ps.executeUpdate()==1) {
//						tableRefresh();
//						JOptionPane.showMessageDialog(null, "Student Information Updated successfully");
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "Failed");
//					}
//				}
//				catch(Exception e1) {
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//		btnUpdate.setBackground(Color.BLUE);
//		btnUpdate.setForeground(Color.BLACK);
//		btnUpdate.setBounds(637, 487, 80, 23);
//		contentPane.add(btnUpdate);
		
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
//		btnDelete.setBackground(Color.RED);
//		btnDelete.setBounds(727, 487, 80, 23);
//		contentPane.add(btnDelete);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(556, 396, 36, 14);
		contentPane.add(lblSubject);
		
		subject = new JTextField();
		subject.setColumns(10);
		subject.setBounds(602, 393, 175, 20);
		contentPane.add(subject);
		
		ID = new JTextField();
		ID.setBounds(602, 146, 175, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		LABELID = new JLabel("id");
		LABELID.setBounds(567, 149, 16, 14);
		contentPane.add(LABELID);
		
		
		contentPane.add(comboBox);

		
	
}
}
