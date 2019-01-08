package com.shiyanlou.lesson8.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shiyanlou.lesson8.domain.Account;

@Mapper
public interface AccountMapper {

	int select(int userId);
		
	int update(Account account);	
}
