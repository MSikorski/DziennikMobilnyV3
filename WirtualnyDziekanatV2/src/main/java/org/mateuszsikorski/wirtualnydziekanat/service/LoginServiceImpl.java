package org.mateuszsikorski.wirtualnydziekanat.service;

import javax.transaction.Transactional;

import org.mateuszsikorski.wirtualnydziekanat.dao.LoginDAO;
import org.mateuszsikorski.wirtualnydziekanat.dao.LoginDAOImpl;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDAO;
	
	private String user;
	private String pass;
	
	private User temp;
	
	public LoginServiceImpl(String user, String pass){
		this.user = user; 
		this.pass = pass;
		temp = null;
	}
	
	public LoginServiceImpl() {
	}
	
	@Transactional
	@Override
	public boolean validate() {
		System.out.println("Validating with loginDetail: " + user + " " + pass + "loginDAO: " + loginDAO);
		String dbPassHash = loginDAO.getUserPassHash(user);
		if(BCrypt.checkpw(pass, dbPassHash)){
			temp = loginDAO.getUser(user);
			return true;
		} 
		else return false; 
	}
	
	public User getUser() {
		return temp;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public String toString() {
		return "LoginDetail [user=" + user + ", pass=" + pass + "]";
	}
}
