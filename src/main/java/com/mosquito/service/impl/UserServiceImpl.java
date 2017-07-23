package com.mosquito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosquito.dao.UserDao;
import com.mosquito.entity.User;
import com.mosquito.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	
	public User getUserById(int id) {
		return userdao.getUserById(id);
	}

	
	public List<User> getAllUser() {
		return userdao.getAllUser();
	}

	
	public void addUser(String username, String email, String password, String rule, String headpic,
			String selfintroduction) {
		userdao.addUser(username, email, password, rule, headpic, selfintroduction);

	}

	
	public void deleteUser(int id) {
		userdao.deleteUser(id);

	}

	
	public User getUserByName(String userName) {
		
		return userdao.getUserByName(userName);
	}

}
