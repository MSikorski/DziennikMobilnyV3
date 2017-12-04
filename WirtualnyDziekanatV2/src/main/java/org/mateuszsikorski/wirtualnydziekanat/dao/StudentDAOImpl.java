package org.mateuszsikorski.wirtualnydziekanat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mateuszsikorski.wirtualnydziekanat.dao.interfaces.StudentDAO;
import org.mateuszsikorski.wirtualnydziekanat.entity.StudentGroup;
import org.mateuszsikorski.wirtualnydziekanat.entity.Subject;
import org.mateuszsikorski.wirtualnydziekanat.entity.TimeTable;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Subject> getSubjectList(User user){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Subject> tempList;
		StudentGroup studentGroup = user.getUserDetail().getStudentDetail().getStudentGroup();
		int timeTableId = studentGroup.getTimeTable().getId();
		String hql = "FROM Subject s WHERE s.timeTableId=" + timeTableId;
		System.out.println(hql);
		
		Query query = currentSession.createQuery(hql);
		
		try{
			tempList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return tempList;
	}

	@Override
	public List<StudentGroup> getStudentGroupList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<StudentGroup> tempList;
		String hql = "FROM StudentGroup";
		Query query = currentSession.createQuery(hql);
		
		try{
			tempList = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return tempList;
	}

	@Override
	public void saveStudentGroup(StudentGroup studentGroup) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(studentGroup);
	}

	@Override
	public void saveTimeTable(TimeTable timeTable) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(timeTable);
	}
	
}
