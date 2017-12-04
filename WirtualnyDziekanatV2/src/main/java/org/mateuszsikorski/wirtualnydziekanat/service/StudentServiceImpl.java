package org.mateuszsikorski.wirtualnydziekanat.service;

import java.util.List;

import org.mateuszsikorski.wirtualnydziekanat.dao.interfaces.StudentDAO;
import org.mateuszsikorski.wirtualnydziekanat.entity.Mark;
import org.mateuszsikorski.wirtualnydziekanat.entity.StudentGroup;
import org.mateuszsikorski.wirtualnydziekanat.entity.Subject;
import org.mateuszsikorski.wirtualnydziekanat.entity.TimeTable;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Subject> getSubjects(User user) {
		return studentDAO.getSubjectList(user);
	}
	
	@Override
	@Transactional
	public List<Mark> getMarks(User user){
		
		return null;
	}

	@Override
	@Transactional
	public TimeTable getTimeTable(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public List<StudentGroup> getStudentGroupList() {
		return studentDAO.getStudentGroupList();
	}

	@Override
	@Transactional
	public void saveStudentGroup(StudentGroup studentGroup) {
		studentDAO.saveStudentGroup(studentGroup);
	}
	
	@Override
	@Transactional
	public void saveTimeTable(TimeTable timeTable) {
		studentDAO.saveTimeTable(timeTable);
	}

}