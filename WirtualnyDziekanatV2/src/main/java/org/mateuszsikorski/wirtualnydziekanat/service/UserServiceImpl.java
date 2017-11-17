package org.mateuszsikorski.wirtualnydziekanat.service;

import javax.transaction.Transactional;

import org.mateuszsikorski.wirtualnydziekanat.dao.UserDAO;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.entity.UserDetail;
import org.mateuszsikorski.wirtualnydziekanat.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void saveUser(User theUser) {
		String temp = theUser.getTempPass();
		theUser.setPassword(BCrypt.hashpw(temp, BCrypt.gensalt()));
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public void saveUserDetail(UserDetail theUserDetail) {

		userDAO.saveUserDetail(theUserDetail);
	}

}
