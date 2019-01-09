package com.shiyanlou.lesson9.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson9.dao.UserMapper;
import com.shiyanlou.lesson9.domain.ResultObject;
import com.shiyanlou.lesson9.domain.User;
import com.shiyanlou.lesson9.service.UserService;
import com.shiyanlou.lesson9.util.RedisUtil;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public ResultObject login(User user) {
		ResultObject resultObject = new ResultObject();
		User fullUser = userMapper.select(user);
		if (fullUser == null) {
			resultObject.setCode(-1);
			resultObject.setMsg("name or password error");
			return resultObject;
		}
		
		String token = UUID.randomUUID().toString();
		int interval = 300;
		redisUtil.set(token, fullUser, interval);
		// 防止同一个账号多人登录
		redisUtil.set(Integer.toString(fullUser.getId()), token, interval);

		resultObject.setCode(1);
		resultObject.setMsg("login success");
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		
		fullUser.setPassword(null);
		map.put("user", fullUser);
		resultObject.setResult(map);
		
		return resultObject;
	}

	@Override
	public ResultObject logout(String token) {
		User user = (User)redisUtil.get(token);
		redisUtil.del(Integer.toString(user.getId()));
		redisUtil.del(token);
		return new ResultObject(1, "success", null);
	}
}
