package org.mateuszsikorski.wirtualnydziekanat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mateuszsikorski.wirtualnydziekanat.dao.interfaces.StudentDAO;
import org.mateuszsikorski.wirtualnydziekanat.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Subject> getSubjectList(int groupId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "FROM StudentGroup";// timetable + studentgroup -> subject list
		return null;
	}

}
