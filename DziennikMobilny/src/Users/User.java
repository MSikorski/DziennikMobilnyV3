package Users;

public class User {
	
	String userName;
	
	String firstName;
	
	String lastName;
	
	String email;
	
	String telephoneNunber;
	
	String password;
	
	boolean Admin;
	
	boolean Teacher;
	
	boolean Student;
	
	boolean Dean;
	
	boolean WebMaster;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNunber() {
		return telephoneNunber;
	}

	public void setTelephoneNunber(String telephoneNunber) {
		this.telephoneNunber = telephoneNunber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public boolean isTeacher() {
		return Teacher;
	}

	public void setTeacher(boolean teacher) {
		Teacher = teacher;
	}

	public boolean isStudent() {
		return Student;
	}

	public void setStudent(boolean student) {
		Student = student;
	}

	public boolean isDean() {
		return Dean;
	}

	public void setDean(boolean dean) {
		Dean = dean;
	}

	public boolean isWebMaster() {
		return WebMaster;
	}

	public void setWebMaster(boolean webMaster) {
		WebMaster = webMaster;
	}
	
}
