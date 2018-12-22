package com.shiyanlou.calculator.serviceImpl;

import org.springframework.stereotype.Service;

import com.shiyanlou.calculator.domain.ResultObject;
import com.shiyanlou.calculator.service.CalculatorService;


@Service
public class CalculatorServiceImpl implements CalculatorService{

	@Override
	public ResultObject compute(String operator, double firstNum, double secondNum) {
		double result = 0;
		int code = 200;
		String msg = "";
		ResultObject resultObject;
		
		switch (operator) {
		case "add":
			result = firstNum + secondNum;
			break;

		case "subtract":
			result = firstNum - secondNum;
			break;
			
		case "divide":
			if (secondNum == 0) {
				msg = "Wrong Parameter";
				code = -1;
				break;
			} else {
				result = firstNum / secondNum;
			}
			break;
			
		case "multiply":
			result = firstNum * secondNum;
			break;

		default:
			msg = "Wrong Operator";
			code = -1;
			break;
		}
		
		resultObject = new ResultObject(result, code, msg);
		return resultObject;
	}

}
