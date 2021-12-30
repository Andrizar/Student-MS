package student;

public class User {
	
	public String firstName,lastName,userName,password;
	public int teacherID;
	
	public User(int teacherID,String firstName,String lastName,String userName,String password) {
		// TODO Auto-generated constructor stub
		super();
		this.teacherID = teacherID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

}
