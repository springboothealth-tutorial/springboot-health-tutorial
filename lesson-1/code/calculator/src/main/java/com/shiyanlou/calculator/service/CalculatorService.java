package com.shiyanlou.calculator.service;


import com.shiyanlou.calculator.domain.ResultObject;

public interface CalculatorService {

	public ResultObject compute(String operator, double firstNum, double secondNum);
}
