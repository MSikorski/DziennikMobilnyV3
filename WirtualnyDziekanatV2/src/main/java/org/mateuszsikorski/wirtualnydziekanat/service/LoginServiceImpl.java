package org.mateuszsikorski.wirtualnydziekanat.service;

import javax.transaction.Transactional;

import org.mateuszsikorski.wirtualnydziekanat.dao.LoginDAO;
import org.mateuszsikorski.wirtualnydziekanat.dao.LoginDAOImpl;
import org.mateuszsikorski.wirtualnydziekanat.dao.UserDAO;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.model.LoginDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	private User temp;
	
	@Transactional
	@Override
	public boolean validate(LoginDetail loginDetail) {
		
		System.out.println("Validating with loginDetail: " + loginDetail + " loginDAO " + loginDAO);
		
		String dbPassHash;
		
		if(loginDAO.checkUser(loginDetail.getUser())){
			dbPassHash = loginDAO.getUserPassHash(loginDetail.getUser());
		} else return false;
			
		if(BCrypt.checkpw(loginDetail.getPass(), dbPassHash)){
			temp = loginDAO.getUser(loginDetail.getUser());
			return true;
		} 
		else return false; 
	}
	
	public User getUser() {
		return temp;
	}
	
}
