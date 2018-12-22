package com.shiyanlou.lesson5.mapper;

import java.util.List;

import com.shiyanlou.lesson5.domain.User;


public interface UserMapper {

	User selectById(int id);

	User selectByJobId(int id);

	List<User> selectAll();
	
	int insert(User user);
		
	int update(User user);
	
	int delete(int id);
}
