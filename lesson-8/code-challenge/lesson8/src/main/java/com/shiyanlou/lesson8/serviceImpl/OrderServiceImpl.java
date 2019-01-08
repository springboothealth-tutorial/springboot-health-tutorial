package com.shiyanlou.lesson8.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shiyanlou.lesson8.dao.AccountMapper;
import com.shiyanlou.lesson8.dao.OrderDetailMapper;
import com.shiyanlou.lesson8.domain.Account;
import com.shiyanlou.lesson8.domain.OrderDetail;
import com.shiyanlou.lesson8.service.OrderDetailService;


@Service
@Transactional
public class OrderServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public String insert(OrderDetail orderDetail) {
		try {
			int money = orderDetail.getMoney();
			int userId = orderDetail.getUserId();
			
			int userBalance = accountMapper.select(userId);
			Account userAccount = new Account(userId, userBalance - money);
			accountMapper.update(userAccount);
			orderDetailMapper.insert(orderDetail);
			
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
}
