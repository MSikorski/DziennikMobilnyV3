package org.mateuszsikorski.wirtualnydziekanat.service;

import org.mateuszsikorski.wirtualnydziekanat.entity.User;

public interface LoginService {

	public boolean validate();
	
	public User getUser();
	
	
}
