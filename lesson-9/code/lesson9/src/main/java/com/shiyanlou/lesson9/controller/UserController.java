package com.shiyanlou.lesson9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson9.domain.ResultObject;
import com.shiyanlou.lesson9.domain.User;
import com.shiyanlou.lesson9.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("login")
	public ResultObject login(@RequestBody User user) {
		if (user == null) {
			return new ResultObject(-1, "param empty", null);
		}
		ResultObject resultObject = userService.login(user);
		return resultObject;
	}
	
	
	@GetMapping("test")
	public ResultObject test() {
		ResultObject resultObject = new ResultObject(1, "test success", null);
		return resultObject;
	}
	
	
	@GetMapping("logout")
	public ResultObject logout(@RequestParam String token) {
		ResultObject resultObject = userService.logout(token);
		return resultObject;
	}

}