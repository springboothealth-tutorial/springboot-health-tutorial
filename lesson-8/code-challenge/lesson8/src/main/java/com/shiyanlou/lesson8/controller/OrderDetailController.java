package com.shiyanlou.lesson8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson8.domain.OrderDetail;
import com.shiyanlou.lesson8.domain.ResultObject;
import com.shiyanlou.lesson8.service.OrderDetailService;

@RestController
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@PostMapping("order")
	public ResultObject add(@RequestBody OrderDetail orderDetail) {
		String status = orderDetailService.insert(orderDetail);
		ResultObject resultObject = new ResultObject(200, status, null);
		return resultObject;
	}
}