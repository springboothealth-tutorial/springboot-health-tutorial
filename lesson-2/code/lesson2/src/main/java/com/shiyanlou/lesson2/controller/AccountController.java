package com.shiyanlou.lesson2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson2.domain.Account;
import com.shiyanlou.lesson2.domain.ResultObject;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@PostMapping("add")
	public ResultObject add(@RequestBody Account account) {
		System.out.println(account);
		return new ResultObject(account);
	}	
}