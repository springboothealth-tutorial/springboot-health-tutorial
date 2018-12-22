package com.shiyanlou.lesson5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson5.domain.User;
import com.shiyanlou.lesson5.mapper.UserMapper;
import com.shiyanlou.lesson5.service.UserService;


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
	
	public User selectUserById(int id) {
		User user = userMapper.selectById(id);
		return user;
	}
	
	public List<User> selectAllUser() {
		List<User> users = userMapper.selectAll();
		return users;
	}
}
