package com.shiyanlou.lesson4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson4.domain.ResultObject;
import com.shiyanlou.lesson4.domain.User;

@RestController
@RequestMapping("user")
public class UserController {

	@GetMapping("online")
	public ResultObject setSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		System.out.println(sessionId);
		
		Object onlineNumber = session.getServletContext().getAttribute("onlineNumber");
		System.out.println(onlineNumber);
		
		return new ResultObject(onlineNumber);
	}
	
	@PostMapping("login")
	public ResultObject login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		
		User realUser = new User("jacky", "112233");
		if (realUser.equals(user)) {
			HttpSession session = request.getSession();
			String sessionId = session.getId();
			System.out.println(sessionId);
			
			session.setAttribute("user", user);
			
			return new ResultObject("login success");
		} else {
			return new ResultObject(-1, "fail", "login fail");
		}
	}
	
	@GetMapping("search")
	public ResultObject search(@RequestParam String word) {
		
		return new ResultObject("search word " + "'" + word + "'" + " is valid.");
	}
}