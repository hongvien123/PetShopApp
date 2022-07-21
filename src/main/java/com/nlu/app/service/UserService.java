package com.nlu.app.service;

import com.nlu.app.entity.UserEntity;

public interface UserService {
	public boolean checkLogin(String username, String password);

	public void saveUser(UserEntity userEntity);

	public UserEntity findByUserName(String username);
}
