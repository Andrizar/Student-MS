package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class CreateTimetable extends JFrame {

	private JPanel contentPane;
	private static JCheckBox check;
	public static Connection con = null;
	private static JComboBox<comboSubject> comboBoxSubject = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTimetable frame = new CreateTimetable();
					frame.setVisible(true);
					con = DBConnect.connect();
					loadSubjects();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void loadSubjects() {
		  try {
		    	String sql = "SELECT * FROM subject";
		   		PreparedStatement pst = con.prepareStatement(sql);
		   		ResultSet rs = pst.executeQuery();
		   		while(rs.next()) {
		   			String subject = rs.getString("subjectName");
		   			String subjectID = rs.getString("subjectID");
		   			Vector<comboSubject> model = new Vector<comboSubject>();
		   	        model.addElement( new comboSubject(subject, subjectID) );
		   	     JComboBox comboBox;

		         //  Easiest approach is to just override toString() method
		         //  of the Item class

		         comboBox = new JComboBox( model );
		   	        comboBoxSubject.setModel((ComboBoxModel<comboSubject>) model);
//		   	     comboBox.addActionListener( this );
//		   	     getContentPane().add(comboBox, BorderLayout.NORTH );
//		   			if(rs.get)
//		   			DefaultComboBoxModel<comboSubject> model = new DefaultComboBoxModel<comboSubject>();
//		   			
//		   			model.addElement(new comboSubject(subject,subjectID));
////		   			model.
//		   			comboBoxSubject.setModel(model);
//		   			Object item = comboBoxSubject.getSelectedItem();
//		   	        JOptionPane.showMessageDialog(null, ((comboSubject)item).getValue());
//		   			comboBoxSubject.addItem(new comboSubject(rs.getString("subjectName"),rs.getString("subjectID")));
//		   			Object item = comboBoxSubject.getSelectedItem();
//		   			JOptionPane.showMessageDialog(this, ((comboBoxSubject)item));
		   		}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
//	public static void checkBox() {
//		String query = "SELECT * FROM subject";
//		try {
//			PreparedStatement pst = con.prepareStatement(query);
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				check.
////				comboBox.addItem(rs.getString("subjectName"));
////				JOptionPane.showMessageDialog(null, comboBox.get);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	/**
	 * Create the frame.
	 */
	public CreateTimetable() {
//		loadSubjects();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateATimetable = new JLabel("Create A Timetable");
		lblCreateATimetable.setBounds(206, 11, 129, 14);
		contentPane.add(lblCreateATimetable);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		comboBoxSubject.setBounds(101, 42, 202, 20);
		contentPane.add(comboBoxSubject);
		
		JCheckBox check = new JCheckBox("New check box");
		check.setBounds(55, 125, 97, 23);
		contentPane.add(check);
     
	       
	}
}
