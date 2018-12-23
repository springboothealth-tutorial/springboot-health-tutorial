package com.shiyanlou.lesson6.mapper;

import java.util.List;

import com.shiyanlou.lesson6.domain.User;

public interface UserMapper {

	User getById(int id);
	
	List<User> getAll();
	
	int insert(User user);
	
	int update(User user);
	
	int delete(int id);
	
}
