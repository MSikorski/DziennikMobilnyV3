package org.mateuszsikorski.wirtualnydziekanat.service.interfaces;

import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.entity.UserDetail;

public interface UserService {

	public void saveUser(User theUser);

	public void saveUserDetail(UserDetail theUserDetail);
	
}
