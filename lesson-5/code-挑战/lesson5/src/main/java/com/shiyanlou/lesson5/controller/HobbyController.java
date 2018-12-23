package com.shiyanlou.lesson5.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.shiyanlou.lesson5.domain.Hobby;
import com.shiyanlou.lesson5.domain.ResultObject;
import com.shiyanlou.lesson5.service.HobbyService;

@RestController
@RequestMapping("hobby")
public class HobbyController {
	
	@Autowired
	private HobbyService hobbyService;
	
	@PostMapping("add")
	public ResultObject add(@RequestBody Hobby hobby) {
		int modifyId = hobbyService.insertHobby(hobby);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	

	@DeleteMapping("delete/{id}")
	public ResultObject delete(@PathVariable int id) {
		int modifyId = hobbyService.deleteHobby(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@PutMapping("modify")
	public ResultObject modify(@RequestBody Hobby hobby) {
		int modifyId = hobbyService.updateHobby(hobby);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("find/{id}")
	public ResultObject find(@PathVariable int id) {
		Hobby hobby = hobbyService.selectHobbyById(id);
		Map<String, Hobby> map = new HashMap<>();
		map.put("hobby", hobby);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("findAll")
	public ResultObject findAll() {
		List<Hobby> hobbies = hobbyService.selectAllHobby();
		Map<String, List<Hobby>> map = new HashMap<>();
		map.put("hobby", hobbies);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
}