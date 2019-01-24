package com.shiyanlou.lesson3.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.shiyanlou.lesson3.MainApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MainApplication.class})
@AutoConfigureMockMvc 
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAdd() throws Exception {
		String params = "{\"id\":1,\"name\":\"jacky\",\"password\":123,\"date\":\"2018-01-01 11:11:11\"}";
		
		RequestBuilder  builder = MockMvcRequestBuilders.post("/account/add")
		.contentType(MediaType.APPLICATION_JSON_UTF8).content(params.getBytes());
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
				.andExpect(MockMvcResultMatchers.jsonPath("msg").value("success"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.id").value("1"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.name").value("jacky"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.date").value("2018-01-01 11:11:11"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.password").doesNotExist())
				.andReturn();
	
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
}
