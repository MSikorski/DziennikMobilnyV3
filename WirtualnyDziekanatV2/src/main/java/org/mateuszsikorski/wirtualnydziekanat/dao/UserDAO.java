package org.mateuszsikorski.wirtualnydziekanat.dao;

import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.entity.UserDetail;

public interface UserDAO {

	public void saveUser(User theUser);

	void saveUserDetail(UserDetail theUserDetail);
	
}
