package com.shiyanlou.lesson6.service;

import java.util.List;

import com.shiyanlou.lesson6.domain.UserIndex;

public interface UserIndexService {
	
	public List<UserIndex> getUserIndexById(UserIndex userIndex);
	
	public int insertUserIndex(UserIndex userIndex);
	
	public int updateUserIndex(UserIndex userIndex);
	
	public int deleteUserIndex(int userIndexId);
}
