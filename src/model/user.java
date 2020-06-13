package model;

public class user {
	private String name;
	private String email;
	private String password;
	private String EmpType;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String name, String email, String password, String empType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		EmpType = empType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpType() {
		return EmpType;
	}
	public void setEmpType(String empType) {
		EmpType = empType;
	}
	
	
	
	
	}
