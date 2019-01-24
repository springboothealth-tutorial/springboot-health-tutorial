package com.shiyanlou.lesson3.test;

import javax.servlet.http.Cookie;

import org.junit.FixMethodOrder;
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
public class CookieControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static Cookie cookie;
	
	@Test
	public void test1SetCookie() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/cookie/set");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.cookie().exists("last"))
				.andExpect(MockMvcResultMatchers.cookie().maxAge("last", 60 * 60 * 24 * 7))
				.andReturn();
		
		cookie = mvcResult.getResponse().getCookie("last");
		System.out.println(cookie.getValue());
	}
	
	@Test
	public void testGetCookie() throws Exception {
		RequestBuilder  builder = MockMvcRequestBuilders.get("/cookie/get")
				.cookie(cookie);
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
	}
	
	@Test
	public void testGetCookieByAnnotation() throws Exception {
		RequestBuilder  builder = MockMvcRequestBuilders.get("/cookie/getByAnnotation")
				.cookie(cookie);
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
	}
}
