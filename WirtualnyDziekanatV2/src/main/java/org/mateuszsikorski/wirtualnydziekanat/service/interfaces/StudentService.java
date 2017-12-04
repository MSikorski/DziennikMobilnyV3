package org.mateuszsikorski.wirtualnydziekanat.service.interfaces;

import java.util.List;

import org.mateuszsikorski.wirtualnydziekanat.entity.Mark;
import org.mateuszsikorski.wirtualnydziekanat.entity.StudentGroup;
import org.mateuszsikorski.wirtualnydziekanat.entity.Subject;
import org.mateuszsikorski.wirtualnydziekanat.entity.TimeTable;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;

public interface StudentService {

	public List<Subject> getSubjects(User user);
	
	public TimeTable getTimeTable(User user);

	public List<Mark> getMarks(User user);

	List<StudentGroup> getStudentGroupList();

	public void saveStudentGroup(StudentGroup studentGroup);

	void saveTimeTable(TimeTable timeTable);
}
