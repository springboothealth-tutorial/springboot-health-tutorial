package com.shiyanlou.lesson2.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson2.domain.ResultObject;

import ch.qos.logback.core.joran.conditional.IfAction;

import com.shiyanlou.lesson2.domain.Book;

@RestController
@RequestMapping("book")
public class BookController {

	private static Map<Integer, Book> bookMap = new HashMap<Integer, Book>();
	
	@PostMapping("add")
	public ResultObject add(@RequestBody Book book) {
		bookMap.put(book.getId(), book);
		return new ResultObject(bookMap);
	}
	
	@DeleteMapping("delete")
	public ResultObject delete(@RequestParam int id) {
		bookMap.remove(id);
		return new ResultObject(bookMap);
	}
	
	@PutMapping("modify")
	public ResultObject modify(@RequestBody Book book) {
		bookMap.put(book.getId(), book);
		return new ResultObject(bookMap);
	}
	
	@GetMapping("find")
	public ResultObject find(@RequestParam int id) {
		Book book = bookMap.get(id);
		return new ResultObject(book);
	}
	
	@GetMapping("findByPagination")
	public ResultObject findByPagination(@RequestParam int pageNum, @RequestParam int pageSize) {
		List<Book> books = new ArrayList<>();
		int total = bookMap.size();
		total = 10;
		// 防止用户pageNum、pageSize输入为负数
		pageNum = pageNum >= 0 ? pageNum : 0;
		pageSize = pageSize >= 0 ? pageSize : 0;
		
		// 防止用户pageNum、pageSize输入数字过大
		int start = pageNum * pageSize <= total ? pageNum * pageSize : total;
		int end = (pageNum + 1) * pageSize <= total ? (pageNum + 1) * pageSize : total;
		
		System.out.println(total + " " + start + " " + end);
		
		for (int i = start; i < end; i++) {
			Book book = bookMap.get(i);
			if (book != null) {
				books.add(book);
			}
		}
		
		return new ResultObject(books);
	}
}