package com.shiyanlou.lesson5.mapper;

import com.shiyanlou.lesson5.domain.Hobby;
import com.shiyanlou.lesson5.domain.User;

public interface UserHobbyMapper {

	public User findUserById(int id);
	public Hobby findHobbyById(int id);
}
