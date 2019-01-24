package com.shiyanlou.lesson3.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson3.domain.ResultObject;
import com.shiyanlou.lesson3.domain.User;

@RestController
@RequestMapping("user")
public class UserController {

	private static Map<Integer, User> userMap = new HashMap<>();
	
	@PostMapping("add")
	public ResultObject add(@RequestBody User user) {
		userMap.put(user.getId(), user);
		return new ResultObject(userMap);
	}
	
	@DeleteMapping("delete/{id}")
	public ResultObject delete(@PathVariable int id) {
		userMap.remove(id);
		return new ResultObject(userMap);
	}
	
	@PutMapping("modify")
	public ResultObject modify(@RequestBody User user) {
		userMap.put(user.getId(), user);
		return new ResultObject(userMap);
	}
	
	@GetMapping("findByPathVariable/{id}")
	public ResultObject findByPathVariable(@PathVariable int id) {
		User user = userMap.get(id);
		return new ResultObject(user);
	}
	
	
	@GetMapping("findByRequestParam")
	public ResultObject findByRequestParam(@RequestParam int id) {
		User user = userMap.get(id);
		return new ResultObject(user);
	}
	
	
	@GetMapping("getHeader")
	public ResultObject getHeader(@RequestHeader String token) {
		HashMap<String, String> map = new HashMap<>();
		map.put("token", token);
		return new ResultObject(map);
	}
	
	
	@GetMapping("getRequest")
	public ResultObject getRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		return new ResultObject(map);
	}
}