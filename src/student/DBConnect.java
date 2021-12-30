package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	 public static Connection connect() throws SQLException, ClassNotFoundException {
		    try {
		    	Class.forName("com.mysql.cj.jdbc.Driver"); 
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolDB","root","");
		        if (con != null) {
		            System.out.println("Connection working");
		        } else {
		            System.out.println("Failed to make connection!");
		        }
		        return con;
		    } catch (SQLException e) {
		        System.out.println("Connection Failed! Check output console");
		        e.printStackTrace();
		        throw e;
		    }
		}

}
