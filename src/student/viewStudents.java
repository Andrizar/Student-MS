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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Label;

public class ViewStudents extends JFrame {
	private JPanel contentPane;
	private static JTable table;
	private JTextField search;
	private JTextField ID;
	private static JComboBox<String> classField;
	private JTextField fName;
	private JTextField lName;
	private JTextField regNo;
	private JTextField age;
	private ButtonGroup bg;
	private JRadioButton rdFemale;
	private JRadioButton rdMale;
	public static Connection con = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudents frame = new ViewStudents();
					frame.setVisible(true);
					con = DBConnect.connect();
					tableRefresh();
					dropDown();
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
	
	public static void dropDown() {
		String query = "SELECT * FROM class";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				classField.addItem(rs.getString("class"));
//				JOptionPane.showMessageDialog(null, comboBox.get);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ViewStudents() {
		setBounds(100, 100, 858, 605);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		getContentPane().setLayout(null);
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(604, 116, 16, 14);
		getContentPane().add(lblId);
		
		bg=new ButtonGroup(); 
		rdFemale = new JRadioButton("Female");
		rdFemale.setActionCommand("Female");
		rdMale = new JRadioButton("Male");
		rdMale.setActionCommand("Male");
		bg.add(rdFemale);
		bg.add(rdMale);
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(545, 149, 84, 14);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(545, 184, 84, 14);
		getContentPane().add(lblLastName);
		
		JLabel lblRegno = new JLabel("regNo");
		lblRegno.setBounds(569, 220, 34, 14);
		getContentPane().add(lblRegno);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(569, 257, 51, 14);
		getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(586, 298, 34, 14);
		getContentPane().add(lblAge);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(586, 335, 34, 14);
		getContentPane().add(lblClass);
		
		Label test = new Label("");
		test.setBounds(569, 410, 62, 22);
		contentPane.add(test);
		
		ID = new JTextField();
		ID.setEditable(false);
		ID.setBounds(630, 113, 202, 20);
		getContentPane().add(ID);
		ID.setColumns(10);
		
		Label label = new Label("New label");
		label.setBounds(0, 0, 62, 22);
		contentPane.add(label);
		
		fName = new JTextField();
		fName.setColumns(10);
		fName.setBounds(630, 146, 202, 20);
		getContentPane().add(fName);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(630, 181, 202, 20);
		getContentPane().add(lName);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(630, 217, 202, 20);
		getContentPane().add(regNo);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(630, 295, 202, 20);
		getContentPane().add(age);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 463, 419);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow(); //get selected row
				String id = dtm.getValueAt(selectedRowIndex, 3).toString();
//				int row = table.getSelectedRow();
//				String RegNo = table.getModel().getValueAt(row, 3).toString();
				try {
					
					
					String query = "SELECT * FROM students WHERE regNo='"+id+"'";
					Statement ps;
					ps = con.createStatement();
					ResultSet rs = ps.executeQuery(query);
					while(rs.next()) {
						ID.setText(rs.getString("sID"));
						fName.setText(rs.getString("FirstName"));
						lName.setText(rs.getString("LastName"));
						regNo.setText(rs.getString("regNo"));
						age.setText(rs.getString("age"));
						classField.addItem(rs.getString("class"));
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}});
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewStudents.super.setVisible(false);
				Home home = new Home();
				home.setVisible(true);
				
			}	
		});
		btnHome.setBounds(10, 11, 89, 23);
		getContentPane().add(btnHome);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(681, 11, 89, 23);
		getContentPane().add(btnLogout);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					 try {
					StudentDAOImpl sid = new StudentDAOImpl();
//					sid.getConnection();
//					if(ID.getText().equals(""), fName.getText(),lName.getText(),regNo.getText(),gender.getText(),age.getText(),classField.getText()) {
//						
//					}
//					ID.
					Student s = new Student(ID.getText(), fName.getText(),lName.getText(),regNo.getText(),bg.getSelection().getActionCommand(),age.getText(),classField.getSelectedItem().toString());	
					sid.addStudent(s);
					
					ID.setText("");
					fName.setText("");
					lName.setText("");
					regNo.setText("");
//					gender.setText("");
					age.setText("");
					classField.addItem("");
					tableRefresh();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					 
			}
		});
		btnSave.setBounds(545, 512, 89, 23);
		getContentPane().add(btnSave);
		

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.BLUE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						try {
							StudentDAOImpl sid = new StudentDAOImpl();
//							sid.getConnection();
							Student s = new Student(ID.getText(),fName.getText(),lName.getText(),regNo.getText(),bg.getSelection().getActionCommand(),age.getText(),classField.getSelectedItem().toString());	
							sid.updateStudent(s);
							ID.setText("");
							fName.setText("");
							lName.setText("");
							regNo.setText("");
//							gender.setText("");
							age.setText("");
							classField.addItem("");
							
							
							tableRefresh();
							JOptionPane.showMessageDialog(null, "Student Information Updated successfully");
							}

						catch(Exception e1) {
							e1.printStackTrace();
						}
						
					}
				});

		btnUpdate.setBounds(644, 512, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StudentDAOImpl sid = new StudentDAOImpl();
//					sid.getConnection();
					Student s = new Student(ID.getText(),fName.getText(),lName.getText(),regNo.getText(),bg.getSelection().getActionCommand(),age.getText(),classField.getSelectedItem().toString());	
					sid.deleteUser(Integer.parseInt(ID.getText()));
					ID.setText("");
					fName.setText("");
					lName.setText("");
					regNo.setText("");
//					gender.setText("");
					age.setText("");
					classField.addItem("");
					
					
						tableRefresh();
						JOptionPane.showMessageDialog(null, "Student Information Updated successfully");
					}

				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(743, 512, 89, 23);
		getContentPane().add(btnDelete);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("regNo");
		comboBox.setBounds(10, 71, 103, 20);
		getContentPane().add(comboBox);
		search = new JTextField();
		System.out.println(comboBox.getSelectedItem().toString());
		search.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(search.getText().equals("")) {
					tableRefresh();
				}
				else {
						try {
							String query = "SELECT sID,FirstName,LastName,regNo,gender,age,class FROM students WHERE gender LIKE '"+search.getText()+"%' OR regNo LIKE '"+search.getText()+"%'";
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
		search.setBounds(150, 71, 190, 20);
		getContentPane().add(search);
		search.setColumns(10);
		
		classField = new JComboBox<String>();
		classField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s = classField.getSelectedIndex();
//				test.setText();
			}
		});
		classField.setBounds(630, 332, 202, 20);
		contentPane.add(classField);
		
		rdMale.setBounds(630, 253, 67, 23);
		contentPane.add(rdMale);
		
		
		rdFemale.setBounds(769, 253, 67, 23);
		contentPane.add(rdFemale);
		
		
		
		
		
		
	}
}
