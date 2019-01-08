package com.shiyanlou.lesson8.service;

import com.shiyanlou.lesson8.domain.User;

public interface UserService {
	
	public int insertUser(User user);
	
	public int deleteUser(int id);
	
	public int updateUser(User user);
	
	public User selectUser(int id);
}
