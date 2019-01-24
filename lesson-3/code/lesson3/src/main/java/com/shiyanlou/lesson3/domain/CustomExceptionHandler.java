package com.shiyanlou.lesson3.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public Object handleException(Exception ex, HttpServletRequest request) {
		return new ResultObject(-1, ex.getMessage(), request.getRequestURL());
	}
	
	@ExceptionHandler(value=CustomException.class)
	public Object handleCustomException(CustomException ex, HttpServletRequest request) {
		return new ResultObject(ex.getCode(), ex.getMsg(), request.getRequestURL());
	}
}
