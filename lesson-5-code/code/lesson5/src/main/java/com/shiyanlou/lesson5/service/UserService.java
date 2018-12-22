package com.shiyanlou.lesson5.service;

import java.util.List;

import com.shiyanlou.lesson5.domain.User;

public interface UserService {
	
	public int insertUser(User user);
	
	public int deleteUser(int id);
	
	public int updateUser(User user);
	
	public User selectUserById(int id);
	
	public List<User> selectAllUser();

}
