package com.shiyanlou.lesson3.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson3.domain.CustomException;
import com.shiyanlou.lesson3.domain.ResultObject;


@RestController
@RequestMapping("exception")
public class ExceptionController {
	@GetMapping("find")
	public ResultObject find() {
		System.out.println(1/0);
		return new ResultObject(null);
	}
	
	@GetMapping("find2")
	public ResultObject find2() {
		throw new CustomException(-1, "CustomException");
	}
}