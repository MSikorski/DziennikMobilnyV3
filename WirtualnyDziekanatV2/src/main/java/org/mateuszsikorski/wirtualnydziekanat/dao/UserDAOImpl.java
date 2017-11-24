package org.mateuszsikorski.wirtualnydziekanat.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mateuszsikorski.wirtualnydziekanat.dao.interfaces.UserDAO;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(User theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUser);
	}
	
	@Override
	public void saveUserDetail(UserDetail theUserDetail){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUserDetail);
	}

}
