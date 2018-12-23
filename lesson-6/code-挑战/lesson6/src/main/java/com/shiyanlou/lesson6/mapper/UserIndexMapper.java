package com.shiyanlou.lesson6.mapper;

import java.util.List;

import com.shiyanlou.lesson6.domain.UserIndex;

public interface UserIndexMapper {

	List<UserIndex> getById(UserIndex userIndex);
		
	int insert(UserIndex userIndex);
	
	int update(UserIndex userIndex);
	
	int delete(int userIndexId);
	
}
