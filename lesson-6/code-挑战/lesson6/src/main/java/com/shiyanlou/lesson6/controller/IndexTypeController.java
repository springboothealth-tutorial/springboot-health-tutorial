package com.shiyanlou.lesson6.controller;


import java.util.HashMap;
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

import com.shiyanlou.lesson6.domain.IndexType;
import com.shiyanlou.lesson6.domain.PaginationObject;
import com.shiyanlou.lesson6.domain.ResultObject;
import com.shiyanlou.lesson6.service.IndexTypeService;


@RestController
@RequestMapping("api/v1/IndexType")
public class IndexTypeController {
	
	@Autowired
	private IndexTypeService indexTypeService;
	
	@PostMapping("add")
	public ResultObject insertIndexType(@RequestBody IndexType indexType) {
		int modifyId = indexTypeService.insertIndexType(indexType);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "", map);		
		return resultObject;
	}
	
	@GetMapping("list")
	public ResultObject getAllIndexType(@RequestParam int pageNum, @RequestParam int pageSize) {
		PaginationObject paginationObj  = indexTypeService.getAllIndexType(pageNum, pageSize);
		ResultObject resultObject = new ResultObject(0, "", paginationObj);
		return resultObject;
	}
	
	@DeleteMapping("delete")
	public ResultObject deleteIndexType(@RequestParam int id) {
		int modifyId = indexTypeService.deleteIndexType(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "", map);
		return resultObject;
	}
	
	@PutMapping("edit")
	public ResultObject updateIndexType(@RequestBody IndexType indexType) {
		int modifyId = indexTypeService.updateIndexType(indexType);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "", map);		
		return resultObject;
	}
}
