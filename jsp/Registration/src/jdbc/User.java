package jdbc;

public class User {
	private int userID; 
	private String firstname;
	private String Lastname;
	private String email;
	private String password;
	private int patientid; 
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
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
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int userID, String firstname, String lastname, String email, String password, int patientid) {
		super();
		this.userID = userID;
		this.firstname = firstname;
		Lastname = lastname;
		this.email = email;
		this.password = password;
		this.patientid = patientid;
	}
	public User() {
		
	}
	
	public String fullname() {
		return getFirstname() +" "+getLastname();
	}
	
	
}
