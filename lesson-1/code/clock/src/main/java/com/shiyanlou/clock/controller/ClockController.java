package com.shiyanlou.clock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.clock.domain.ResultObject;
import com.shiyanlou.clock.service.ClockService;

@RestController
@RequestMapping("clock")
public class ClockController {

	@Autowired
	ClockService clockService;
	
	@GetMapping("get/{firstDate}/{lastDate}")
	public ResultObject getClock(@PathVariable String firstDate, @PathVariable String lastDate) {
		ResultObject resultObject = clockService.getDiff(firstDate, lastDate);
		return resultObject;
	}

}
