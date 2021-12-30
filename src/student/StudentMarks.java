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
import javax.swing.DefaultComboBoxModel;

public class StudentMarks extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTable table;
	private static JComboBox<comboSubject> comboBox;
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
//					comboSubject cs;
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
			String query = "SELECT sID,FirstName,LastName,regNo,gender,age,class FROM students";
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
				comboBox.addItem(new comboSubject(rs.getString("subjectName"),rs.getString("subjectID")));
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
		JLabel test = new JLabel("");
		test.setBounds(629, 278, 46, 14);
		contentPane.add(test);
		table = new JTable();
		scrollPane.setViewportView(table);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				PreparedStatement pst;
				String query = "INSERT INTO marks(sID,subjectID,mark,GRADE,Remark) VALUES(?,?,?,?,?)";
				try {
					if(Integer.parseInt(mark.getText())>80) {
						pst = con.prepareStatement(query);
						pst.setString(1,sID.getText());
						pst.setString(2,Integer.toString(comboBox.getSelectedIndex()));
						pst.setString(3,mark.getText());
						pst.setString(4,"D1");
						pst.setString(5,"Excellent");
						if(pst.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Student Mark Added Successfully");
						}
					}
					else if(Integer.parseInt(mark.getText())>70 && Integer.parseInt(mark.getText())<80) {
						pst = con.prepareStatement(query);
						pst.setString(1,sID.getText());
						pst.setString(2,Integer.toString(comboBox.getSelectedIndex()));
						pst.setString(3,mark.getText());
						pst.setString(4,"D2");
						pst.setString(5,"Very Good");
						if(pst.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Student Mark Added Successfully");
						}
					
					}
					else if(Integer.parseInt(mark.getText())>50 && Integer.parseInt(mark.getText())<70) {
						pst = con.prepareStatement(query);
						pst.setString(1,sID.getText());
						pst.setString(2,Integer.toString(comboBox.getSelectedIndex()));
						pst.setString(3,mark.getText());
						pst.setString(4,"Credit");
						pst.setString(5,"Good");
						if(pst.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Student Mark Added Successfully");
						}
					
					}
					else if(Integer.parseInt(mark.getText())<50) {
						pst = con.prepareStatement(query);
						pst.setString(1,sID.getText());
						pst.setString(2,Integer.toString(comboBox.getSelectedIndex()));
						pst.setString(3,mark.getText());
						pst.setString(4,"Fail");
						pst.setString(5,"Poor");
						if(pst.executeUpdate()==1) {
							JOptionPane.showMessageDialog(null, "Student Mark Added Successfully");
						}
					
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				test.setText(Integer.toString(comboBox.getSelectedIndex()));
			}
		});
		btnAddMark.setBounds(626, 331, 89, 23);
		contentPane.add(btnAddMark);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow(); //get selected row
				String id = dtm.getValueAt(selectedRowIndex, 0).toString();
//				int row = table.getSelectedRow();
//				String RegNo = table.getModel().getValueAt(row, 3).toString();
				try {
					
					
					String query = "SELECT * FROM students WHERE sID='"+id+"'";
					Statement ps;
					ps = con.createStatement();
					ResultSet rs = ps.executeQuery(query);
					while(rs.next()) {
						sID.setText(rs.getString("sID"));
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
