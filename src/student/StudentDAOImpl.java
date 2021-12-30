package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class StudentDAOImpl implements StudentDAO{
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO students(FirstName,LastName,regNo,gender,age,class) VALUES(?,?,?,?,?,?)";
	private static final String UPDATE_STUDENT_SQL = "UPDATE students SET FirstName=?,LastName=?,regNo=?,gender=?,age=?,class=? WHERE sID=?";
	private static final String DELETE_STUDENT_SQL = "DELETE FROM students WHERE sID = ?";
	private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	public Connection getConnection() {
		Connection con = null;
		 try {
		    	Class.forName("com.mysql.cj.jdbc.Driver"); 
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolDB","root","");
		        if (con != null) {
		            System.out.println("Connection working");
		        } else {
		            System.out.println("Failed to make connection!");
		        }
		       
		    } catch (SQLException e) {
		        System.out.println("Connection Failed! Check output console");
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return con;
	}
	
	public void addStudent(Student student) throws SQLException{
		System.out.println("0");
		try{
			Connection con = getConnection();
			System.out.println("1");
			PreparedStatement pst = con.prepareStatement(INSERT_STUDENT_SQL);
			System.out.println("2");
			pst.setString(1, student.firstName);
			pst.setString(2, student.lastName);
			pst.setString(3, student.regNo);
			pst.setString(4, student.gender);
			pst.setString(5, student.age);
			pst.setString(6, student.Class);
			System.out.println("3");
			pst.executeUpdate();
			System.out.println("4");
			JOptionPane.showMessageDialog(null, "Student Updated Successfully");
			System.out.println("5");
	}
		catch(Exception e) {
			
		}
	}

	@Override
	public boolean updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		System.out.println("1");
		PreparedStatement pst = con.prepareStatement(UPDATE_STUDENT_SQL);
		System.out.println("2");
		pst.setString(1, student.firstName);
		pst.setString(2, student.lastName);
		pst.setString(3, student.regNo);
		pst.setString(4, student.gender);
		pst.setString(5, student.age);
		pst.setString(6, student.Class);
		pst.setInt(7,Integer.parseInt(student.id));
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Student Updated Successfully");
		return true;
	}
//	@Override
//	public void selectAllUsers() throws SQLException {
//		// TODO Auto-generated method stub
//		Connection con = getConnection();
//		Statement pst = con.createStatement();
//		ResultSet rs = pst.executeQuery(SELECT_ALL_STUDENTS);
//		while(rs.next()) {
//			rs.getString("id");
//			rs.getString("FirstName");
//		}
//	}
	@Override
	public Student selectStudent(int id) throws SQLException {
		// TODO Auto-generated method stub
//		Connection con = getConnection();
//		PreparedStatement pst = con.prepareStatement(DELETE_STUDENT_SQL);
//		
		return null;
	}
	@Override
	public boolean deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement(DELETE_STUDENT_SQL);
		System.out.println("2");
		pst.setInt(1, id);
		pst.executeUpdate();
		return false;
	}

}












