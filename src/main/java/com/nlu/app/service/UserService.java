package com.nlu.app.service;

import com.nlu.app.entity.User;

public interface UserService {
	public boolean checkLogin(String username, String password);

	public void saveUser(User userEntity);

	public User findByUserName(String username);
	
	public User findByEmail(String email);
	
	public User createUser(User form);


}
