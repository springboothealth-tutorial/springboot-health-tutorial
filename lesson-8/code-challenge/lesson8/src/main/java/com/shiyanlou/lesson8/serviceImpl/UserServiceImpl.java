package com.shiyanlou.lesson8.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson8.dao.UserMapper;
import com.shiyanlou.lesson8.domain.User;
import com.shiyanlou.lesson8.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public int insertUser(User user) {
		int modifyId = userMapper.insert(user);
		return modifyId;
	}
	
	public int deleteUser(int id) {
		int modifyId = userMapper.delete(id);
		return modifyId;
	}
	
	public int updateUser(User user) {
		int modifyId = userMapper.update(user);
		return modifyId;
	}
	
	public User selectUser(int id) {
		User user = userMapper.select(id);
		return user;
	}
}
