package com.shiyanlou.lesson6.service;

import com.shiyanlou.lesson6.domain.PaginationObject;
import com.shiyanlou.lesson6.domain.User;

public interface UserService {

	public int insertUser(User user);
	
	public User getUserById(int id);
	
	public PaginationObject getAllUser(int pageNum, int pageSize);
	
	public int updateUser(User user); 
	
	public int deleteUser(int id);
}
