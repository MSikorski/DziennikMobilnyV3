package org.mateuszsikorski.wirtualnydziekanat.dao.interfaces;

import java.util.List;

import org.mateuszsikorski.wirtualnydziekanat.entity.Subject;

public interface StudentDAO {

	public List<Subject> getSubjectList(int groupId);

}
