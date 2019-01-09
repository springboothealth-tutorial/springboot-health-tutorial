package com.shiyanlou.lesson9.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shiyanlou.lesson9.domain.User;

@Mapper
public interface UserMapper {
	User select(User user);
}
