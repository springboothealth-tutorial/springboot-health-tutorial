package com.shiyanlou.lesson3.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson3.domain.ResultObject;

@RestController
@RequestMapping("cookie")
public class CookieController {
	
	@GetMapping("set")
	public ResultObject setCookie(HttpServletRequest request, HttpServletResponse response) {
		String time = String.valueOf(System.currentTimeMillis()); 
		Cookie cookie = new Cookie("last", time);
		cookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie);
		return new ResultObject(null);
	}
	
	@GetMapping("get")
	public ResultObject getCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie cookie: cookies) {
				if (cookie.getName().equals("last")) {
					System.out.println(cookie.getValue());
					return new ResultObject(null);
				}
			}
		}
		return new ResultObject(-1, "get cookie fail");
	}
	
	@GetMapping("getByAnnotation")
	public ResultObject getCookieByAnnotation(@CookieValue("last") String last) {
		System.out.println(last);
		return new ResultObject(null);
	}
}