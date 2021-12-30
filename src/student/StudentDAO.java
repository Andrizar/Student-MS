package student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
	void addStudent(Student student) throws SQLException;
	boolean updateStudent(Student student) throws SQLException;
//	void selectAllUsers() throws SQLException;
	Student selectStudent(int id) throws SQLException;
	boolean deleteUser(int id) throws SQLException;
	
}
