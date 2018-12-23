package com.shiyanlou.random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.random.domain.ResultObject;
import com.shiyanlou.random.service.RandomService;

@RestController
@RequestMapping("/random")
public class RandomController {

	@Autowired
	private RandomService randomService;
	
	@GetMapping("/get/{randomCounter}/{randomMin}/{randomMax}")
	public ResultObject getRandom(@PathVariable int randomCounter, 
			@PathVariable int randomMin, @PathVariable int randomMax) {
		ResultObject resultObject = randomService.getRandom(randomCounter, randomMin, randomMax);
		return resultObject;
	}
}
