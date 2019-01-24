package com.shiyanlou.lesson3.test;

import javax.servlet.http.Cookie;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.junit.runners.MethodSorters;
import com.shiyanlou.lesson3.MainApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MainApplication.class})
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static Cookie cookie;
	
	@Test
	public void test1SetSession() throws Exception {
		RequestBuilder  builder = MockMvcRequestBuilders.get("/session/set");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
//		cookie = mvcResult.getResponse().getCookie("JSESSIONID");
//		System.out.println(cookie.getValue());
		
		Cookie[] cookies = mvcResult.getResponse().getCookies();
		System.out.println(123);
		for (Cookie cookie: cookies) {
			System.out.println(123);
			System.out.println(cookie.getName());
		}
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		
//		mockMvc.perform(builder)
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andDo(MockMvcResultHandlers.print());
	}
	
	@Ignore
	public void test2GetSession() throws Exception {
		RequestBuilder  builder = MockMvcRequestBuilders.get("/session/get")
				.cookie(cookie);
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
	}
}
