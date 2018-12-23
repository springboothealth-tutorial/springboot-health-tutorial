package com.shiyanlou.lesson6.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson6.domain.ResultObject;
import com.shiyanlou.lesson6.domain.UserIndex;
import com.shiyanlou.lesson6.service.UserIndexService;


@RestController
@RequestMapping("api/v1/userIndex")
public class UserIndexController {
	
	@Autowired
	private UserIndexService userIndexService;
	
	@PostMapping("add")
	public ResultObject insertUserIndex(@RequestBody UserIndex userIndex) {
		int modifyId = userIndexService.insertUserIndex(userIndex);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "", map);
		return resultObject;
	}
	
	@GetMapping("get")
	public ResultObject getUserIndexById(@RequestBody UserIndex userIndex) {
		List<UserIndex> userIndexIndexs = userIndexService.getUserIndexById(userIndex);
		ResultObject resultObject = new ResultObject(200, "", userIndexIndexs);
		return resultObject;
	}
	
	@DeleteMapping("delete")
	public ResultObject deleteUserIndex(@RequestParam int id) {
		int modifyId = userIndexService.deleteUserIndex(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "", map);
		return resultObject;
	}
	
	@PutMapping("edit")
	public ResultObject updateUserIndex(@RequestBody UserIndex userIndex) {
		int modifyId = userIndexService.updateUserIndex(userIndex);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "", map);
		return resultObject;
	}
}
