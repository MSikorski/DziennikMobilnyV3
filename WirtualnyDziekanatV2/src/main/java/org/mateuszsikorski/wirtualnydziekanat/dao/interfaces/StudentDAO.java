package org.mateuszsikorski.wirtualnydziekanat.dao.interfaces;

import java.util.List;

import org.mateuszsikorski.wirtualnydziekanat.entity.StudentGroup;
import org.mateuszsikorski.wirtualnydziekanat.entity.Subject;
import org.mateuszsikorski.wirtualnydziekanat.entity.TimeTable;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;

public interface StudentDAO {

	List<Subject> getSubjectList(User user);

	List<StudentGroup> getStudentGroupList();

	void saveStudentGroup(StudentGroup studentGroup);

	void saveTimeTable(TimeTable timeTable);

}
