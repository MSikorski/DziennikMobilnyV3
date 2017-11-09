package mateuszsikorski.wirtualnydziekanat.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mateuszsikorski.wirtualnydziekanat.dao.UserDAO;
import mateuszsikorski.wirtualnydziekanat.entity.User;
import mateuszsikorski.wirtualnydziekanat.entity.UserDetail;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void saveUser(User theUser) {

		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public void saveUserDetail(UserDetail theUserDetail) {

		userDAO.saveUserDetail(theUserDetail);
	}

}
