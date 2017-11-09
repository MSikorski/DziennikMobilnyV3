package mateuszsikorski.wirtualnydziekanat.dao;

import mateuszsikorski.wirtualnydziekanat.entity.User;
import mateuszsikorski.wirtualnydziekanat.entity.UserDetail;

public interface UserDAO {

	public void saveUser(User theUser);

	void saveUserDetail(UserDetail theUserDetail);
	
}
