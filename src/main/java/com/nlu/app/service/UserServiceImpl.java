package com.nlu.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.UserEntity;
import com.nlu.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean checkLogin(String username, String password) {
		for (UserEntity user : userRepository.findAll()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveUser(UserEntity userEntity) {
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		
		userRepository.save(userEntity);
		
	}

	@Override
	public UserEntity findByUserName(String username) {
		for (UserEntity user : userRepository.findAll()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	

}
