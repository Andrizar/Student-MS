package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class StudentMarks extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTable table;
	private static JComboBox<String> comboBox;
	public static Connection con = null;
	private static JTextField sID;
	private JTextField mark;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMarks frame = new StudentMarks();
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
//			String query = "SELECT students.sID, students.regNo, students.class FROM students INNER JOIN marks ON marks.sID=students.sID;";
			String query = "SELECT students.FirstName, students.LastName,students.regNo,subject.subjectName, marks.mark,marks.Remark FROM students JOIN marks ON students.sID = marks.sID JOIN subject ON subject.subjectID = marks.subjectID";
//			String query = "SELECT sID,FirstName,LastName,regNo,gender,age,class FROM students";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(Exception e) {
			
		}
	}

	
	public static void dropDown() {
		String query = "SELECT * FROM subject";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString("subjectName"));
//				JOptionPane.showMessageDialog(null, comboBox.get);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public StudentMarks() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 516, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String sql = "SELECT id FROM ";
//				PreparedStatement ps = con.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
			}
		});
		comboBox.setBounds(626, 170, 130, 20);
		contentPane.add(comboBox);
		
		sID = new JTextField();
		sID.setBounds(629, 123, 86, 20);
		contentPane.add(sID);
		sID.setColumns(10);
		
		mark = new JTextField();
		mark.setColumns(10);
		mark.setBounds(626, 220, 86, 20);
		contentPane.add(mark);
		
		JButton btnAddMark = new JButton("Add Mark");
		btnAddMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAddMark.setBounds(626, 331, 89, 23);
		contentPane.add(btnAddMark);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow(); //get selected row
				String id = dtm.getValueAt(selectedRowIndex, 3).toString();
//				int row = table.getSelectedRow();
//				String RegNo = table.getModel().getValueAt(row, 3).toString();
				try {
					String sql = "SELECT subjectID FROM subject WHERE subjectName='"+comboBox.getSelectedItem().toString()+"'";
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int subjectID = rs.getInt("subjectID");
					JOptionPane.showMessageDialog(null,  rs.getInt("subjectID"));
//					if(mark.getText()>=90) {
						String query = "INSERT INTO marks(sID,subjectID,marks,Remarks) VALUES(?,?,?,?)'";
						
						ps = con.prepareStatement(query);
						ps.setString(1,sID.getText());
						ps.setInt(2,subjectID);
						ps.setString(3,sID.getText());
						if(ps.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null,"Students Marks added");
						}
//					}
////					else if(Integer.parseInt(sID.getText())<=50) {
//						String remark="Fail";
//						String query1 = "INSERT INTO marks(sID,subjectID,marks) VALUES(?,?,?)'";
//						
//						ps = con.prepareStatement(query1);
//						ps.setInt(1,Integer.parseInt(sID.getText()));
//						ps.setInt(2,subjectID);
//						ps.setInt(3,Integer.parseInt(sID.getText()));
//						if(ps.executeUpdate()==1) {
//							JOptionPane.showMessageDialog(null,"Students Marks added");
//						}
////					}
					String query2 = "INSERT INTO marks(sID,subjectID,marks) VALUES(?,?,?)'";
					
					ps = con.prepareStatement(query2);
					ps.setInt(1,Integer.parseInt(sID.getText()));
					ps.setInt(2,subjectID);
					ps.setInt(3,Integer.parseInt(sID.getText()));
					if(ps.executeUpdate()==1) {
						
					}
//					while(rs.next()) {
//						ID.setText(rs.getString("sID"));
//						fName.setText(rs.getString("FirstName"));
//						lName.setText(rs.getString("LastName"));
	//
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 	
	}
}
