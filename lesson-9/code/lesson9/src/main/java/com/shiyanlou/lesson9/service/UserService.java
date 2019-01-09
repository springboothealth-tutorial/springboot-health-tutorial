package com.shiyanlou.lesson9.service;

import com.shiyanlou.lesson9.domain.ResultObject;
import com.shiyanlou.lesson9.domain.User;

public interface UserService {
	public ResultObject login(User user);
	public ResultObject logout(String token);
}
