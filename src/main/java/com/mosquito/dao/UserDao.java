package com.mosquito.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mosquito.entity.User;

public interface UserDao {

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
	User getUserByName(@Param("userName")String userName);
	
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
	void addUser(@Param("username")String username,@Param("email")String email,@Param("password")String password,@Param("rule")String rule,@Param("headpic")String headpic,@Param("selfintroduction")String selfintroduction);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(int id);
	
	//void updateUser();
	
}
