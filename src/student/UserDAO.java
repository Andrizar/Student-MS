package student;

import java.sql.SQLException;

public interface UserDAO {
	void addTeacher(User user) throws SQLException;
	boolean updateTeacher(User user) throws SQLException;

}
