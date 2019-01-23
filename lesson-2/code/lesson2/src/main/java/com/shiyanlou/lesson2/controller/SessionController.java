package com.shiyanlou.lesson2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson2.domain.ResultObject;

@RestController
@RequestMapping("session")
public class SessionController {
	
	@GetMapping("set")
	public ResultObject setSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		System.out.println(sessionId);
		
		session.setAttribute("company", "shiyanlou");

		return new ResultObject(null);
	}
	
	@GetMapping("get")
	public ResultObject getSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("company");
		return new ResultObject(name);
	}
}