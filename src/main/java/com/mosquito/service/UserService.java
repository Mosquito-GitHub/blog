package com.mosquito.service;

import java.util.List;


import com.mosquito.entity.User;

public interface UserService {

	
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	
	/**
	 * 获取用户
	 * @param username
	 * @return
	 */
	User getUserByName(String userName);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<User> getAllUser();
	
	/**
	 * 添加用户
	 * @param username
	 * @param email
	 * @param password
	 * @param rule
	 * @param headpic
	 * @param selfintroduction
	 */
	void addUser(String username,String email,String password,String rule,String headpic,String selfintroduction);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(int id);
	
	//void updateUser();
}
