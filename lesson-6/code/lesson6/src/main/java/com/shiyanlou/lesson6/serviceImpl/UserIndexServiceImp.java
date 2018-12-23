package com.shiyanlou.lesson6.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson6.domain.UserIndex;
import com.shiyanlou.lesson6.mapper.UserIndexMapper;
import com.shiyanlou.lesson6.service.UserIndexService;



@Service
public class UserIndexServiceImp implements UserIndexService{

	@Autowired
	private UserIndexMapper userIndexMapper;	
	
	public List<UserIndex> getUserIndexById(UserIndex userIndex) {
		List<UserIndex> userIndexs = userIndexMapper.getById(userIndex);
		return userIndexs;
	}
	
	public int insertUserIndex(UserIndex userIndex) {
		userIndex.setCollectDate(new java.sql.Date(new Date().getTime()));
		int modifyId = userIndexMapper.insert(userIndex);
		return modifyId; 
	}
	
	public int updateUserIndex(UserIndex userIndex) {
		int modifyId = userIndexMapper.update(userIndex);
		return modifyId;
	}
	
	public int deleteUserIndex(int userIndexId) {
		int modifyId = userIndexMapper.delete(userIndexId);
		return modifyId;
	}
}
