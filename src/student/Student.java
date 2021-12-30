package student;

import javax.swing.JTextField;

public class Student {

	public String firstName,lastName,regNo,gender,age,Class,password,userName;
	String id;
	
	public Student() {
		
	}
	public Student(String id,String firstName,String lastName,String regNo,String gender,String age,String Class) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNo = regNo;
		this.gender = gender;
		this.age = age;
		this.Class = Class;
	}
}
