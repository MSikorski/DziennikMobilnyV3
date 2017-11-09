package mateuszsikorski.wirtualnydziekanat.service;

import mateuszsikorski.wirtualnydziekanat.entity.User;
import mateuszsikorski.wirtualnydziekanat.entity.UserDetail;

public interface UserService {

	public void saveUser(User theUser);

	public void saveUserDetail(UserDetail theUserDetail);
	
}
