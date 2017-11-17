package org.mateuszsikorski.wirtualnydziekanat.model;

import org.mateuszsikorski.wirtualnydziekanat.entity.AdminDetail;
import org.mateuszsikorski.wirtualnydziekanat.entity.StudentDetail;
import org.mateuszsikorski.wirtualnydziekanat.entity.TeacherDetail;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;

public class Privagles {

	private boolean studentPrivagles;
	private boolean teacherPrivagles;
	private boolean adminPrivagles;
	
	public Privagles() {
		studentPrivagles = true;
		teacherPrivagles = true;
		adminPrivagles = true;
	}
	
	public User Validate(User user) {
		
		if(studentPrivagles && user.getUserDetail().getStudentDetail() == null)
			user.getUserDetail().setStudentDetail(new StudentDetail(user.getUserDetail()));
		else if(!studentPrivagles && !(user.getUserDetail().getStudentDetail() == null))
			user.getUserDetail().setStudentDetail(null);
		
		if(teacherPrivagles && user.getUserDetail().getTeacherDetail() == null)
			user.getUserDetail().setTeacherDetail(new TeacherDetail(user.getUserDetail()));
		else if(!teacherPrivagles && !(user.getUserDetail().getTeacherDetail() == null))
			user.getUserDetail().setTeacherDetail(null);
		
		if(adminPrivagles && user.getUserDetail().getAdminDetail() == null)
			user.getUserDetail().setAdminDetail(new AdminDetail(user.getUserDetail()));
		else if(!adminPrivagles && !(user.getUserDetail().getAdminDetail() == null))
			user.getUserDetail().setAdminDetail(null);
		
		return user;
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
