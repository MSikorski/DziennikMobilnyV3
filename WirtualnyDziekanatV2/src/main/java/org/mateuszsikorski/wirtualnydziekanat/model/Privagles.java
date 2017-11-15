package org.mateuszsikorski.wirtualnydziekanat.model;

public class Privagles {

	private boolean studentPrivagles;
	private boolean teacherPrivagles;
	private boolean adminPrivagles;
	
	public Privagles() {
		studentPrivagles = true;
		teacherPrivagles = true;
		adminPrivagles = true;
	}

	public boolean isStudentPrivagles() {
		return studentPrivagles;
	}

	public void setStudentPrivagles(boolean studentPrivagles) {
		this.studentPrivagles = studentPrivagles;
	}

	public boolean isTeacherPrivagles() {
		return teacherPrivagles;
	}

	public void setTeacherPrivagles(boolean teacherPrivagles) {
		this.teacherPrivagles = teacherPrivagles;
	}

	public boolean isAdminPrivagles() {
		return adminPrivagles;
	}

	public void setAdminPrivagles(boolean adminPrivagles) {
		this.adminPrivagles = adminPrivagles;
	}
	
}
