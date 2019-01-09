package com.shiyanlou.lesson9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson9.domain.ResultObject;
import com.shiyanlou.lesson9.service.CounterService;


@RestController
@RequestMapping("redis")
public class CounterController {
	
	@Autowired
	private CounterService counterService;
	
	@GetMapping("decr")
	public ResultObject decr(@RequestParam long delta) {
		ResultObject resultObject = counterService.decr(delta);
		return resultObject;
	}
	
	
	@GetMapping("get")
	public ResultObject get() {
		ResultObject resultObject = counterService.get();
		return resultObject;
	}
}