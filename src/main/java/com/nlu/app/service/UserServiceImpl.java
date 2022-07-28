package com.nlu.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.app.entity.User;
import com.nlu.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	


	@Override
	public boolean checkLogin(String username, String password) {
		for (User user : userRepository.findAll()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveUser(User userEntity) {
//		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		
		userRepository.save(userEntity);
		
	}

	@Override
	public User findByUserName(String username) {
		for (User user : userRepository.findAll()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User form) {
		User user = new User(form.getUsername(), form.getPassword(), form.getPasswordConfirm(), form.getEmail());
		
		return user;
	}
}
