package com.shiyanlou.lesson8.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shiyanlou.lesson8.domain.User;

@Mapper
public interface UserMapper {

	User select(int id);
	
	int insert(User user);
		
	int update(User user);
	
	int delete(int id);
}
