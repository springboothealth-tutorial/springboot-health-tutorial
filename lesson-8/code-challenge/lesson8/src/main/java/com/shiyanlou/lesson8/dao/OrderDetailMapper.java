package com.shiyanlou.lesson8.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shiyanlou.lesson8.domain.OrderDetail;

@Mapper
public interface OrderDetailMapper {
	int insert(OrderDetail orderDetail);	
}
