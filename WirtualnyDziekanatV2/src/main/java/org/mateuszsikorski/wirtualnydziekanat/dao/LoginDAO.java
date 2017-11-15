package org.mateuszsikorski.wirtualnydziekanat.dao;

import org.mateuszsikorski.wirtualnydziekanat.entity.User;

public interface LoginDAO {
	
	public String getUserPassHash(String user);
	
	public User getUser(String user);

	boolean checkUser(String user);

}
