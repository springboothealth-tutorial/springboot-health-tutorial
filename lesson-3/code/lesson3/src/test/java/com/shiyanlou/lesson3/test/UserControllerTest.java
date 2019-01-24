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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.shiyanlou.lesson3.MainApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MainApplication.class})
@AutoConfigureMockMvc 
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAdd() throws Exception {
		
		String params = "{\"id\":1,\"name\":\"jacky\",\"gender\":1,\"age\":24}";
		
		RequestBuilder  builder = MockMvcRequestBuilders.post("/user/add")
		.contentType(MediaType.APPLICATION_JSON_UTF8).content(params.getBytes());
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
				.andExpect(MockMvcResultMatchers.jsonPath("msg").value("success"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.id").value("1"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.name").value("jacky"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.age").value("24"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.gender").value("1"))
				.andReturn();

		mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
	
	@Test
	public void testFindByRequestParam() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/user/findByRequestParam")
		.param("id", "1");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
	
	@Test
	public void testModify() throws Exception {
		
		String params = "{\"id\":1,\"name\":\"mary\",\"gender\":0,\"age\":23}";
		
		RequestBuilder  builder = MockMvcRequestBuilders.put("/user/modify")
		.contentType(MediaType.APPLICATION_JSON_UTF8).content(params.getBytes());
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
				.andReturn();

//		mockMvc.perform(builder)
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andDo(MockMvcResultHandlers.print());
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
	
	@Test
	public void testFindByPathVariable() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/user/findByPathVariable/1");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}

	@Test
	public void testDelete() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.delete("/user/delete/1");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
	
	@Test
	public void testGetHeader() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/user/getHeader")
		.header("token", "abcdefg");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
	
	@Test
	public void testGetRequest() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/user/getRequest")
		.param("id", "123456");
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
}
