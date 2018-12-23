package com.shiyanlou.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.calculator.domain.ResultObject;
import com.shiyanlou.calculator.service.CalculatorService;

@RestController
public class CalculatorController {
	
	@Autowired
	private CalculatorService sampleService;
		
	@RequestMapping("/compute/{operator}/{firstNum}/{secondNum}")
	public ResultObject compute(@PathVariable String operator,
			@PathVariable double firstNum, @PathVariable double secondNum) {
		ResultObject resultObject = sampleService.compute(operator, firstNum, secondNum);
		return resultObject;
	}
}