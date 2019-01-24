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
public class bookControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAdd() throws Exception {
		
		String params = "{\"id\":1,\"name\":\"java\",\"author\":\"jacky\",\"press\":\"haha\"}";
		
		RequestBuilder  builder = MockMvcRequestBuilders.post("/book/add")
		.contentType(MediaType.APPLICATION_JSON_UTF8).content(params.getBytes());
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
				.andExpect(MockMvcResultMatchers.jsonPath("msg").value("success"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.id").value("1"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.name").value("java"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.author").value("jacky"))
				.andExpect(MockMvcResultMatchers.jsonPath("result.1.press").value("haha"))
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
	public void testFind() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/book/find")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
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
		
		String params = "{\"id\":1,\"name\":\"python\",\"author\":\"lili\",\"press\":\"hihi\"}";
		
		RequestBuilder  builder = MockMvcRequestBuilders.put("/book/modify")
		.contentType(MediaType.APPLICATION_JSON_UTF8).content(params.getBytes());
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("code").value("0"))
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
	
	@Test
	public void testFindByPagination() throws Exception {
		
		RequestBuilder  builder = MockMvcRequestBuilders.get("/book/findByPagination")
				.param("pageNum", "0")
				.param("pageSize", "1")
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		
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
		
		RequestBuilder  builder = MockMvcRequestBuilders.delete("/book/delete")
				.param("id", "1")
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		
		MvcResult mvcResult = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		System.out.println(response);
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}
}
