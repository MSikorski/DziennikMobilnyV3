package org.mateuszsikorski.wirtualnydziekanat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String getUserPassHash(String user) {

		System.out.println("getUserPassHash called");
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "SELECT u.password FROM user u WHERE u.userName=" + user;
		System.out.println(hql);
		Query query = currentSession.createQuery(hql);

		String temp = (String) query.getSingleResult();

		if(temp == null)
			System.out.println("failed to retrieve any dbPassHash with given user="+ user);
		else 
			System.out.println("retrieved " + temp);

		return temp;
	}

	@Override
	public User getUser(String user) {

		Session currentSession = sessionFactory.getCurrentSession();

		String hql = "FROM user U WHERE U.user_name=" + user;
		Query query = currentSession.createQuery(hql);

		List<User> temp = query.getResultList();
		
		return temp.get(0);
	}
}
