package com.shiyanlou.lesson8.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shiyanlou.lesson8.dao.AccountMapper;
import com.shiyanlou.lesson8.domain.Account;
import com.shiyanlou.lesson8.domain.TransferDetail;
import com.shiyanlou.lesson8.service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public String transfer(TransferDetail transferDetail) {
		try {
			int money = transferDetail.getMoney();
			int userId = transferDetail.getUserId();
			int doctorId = transferDetail.getDoctorId();
			
			int userBalance = accountMapper.select(userId);
			int doctorBalance = accountMapper.select(doctorId);

			if (userBalance >= money) {
				Account userAccount = new Account(userId, userBalance - money);
				accountMapper.update(userAccount);
				Account doctorAccount = new Account(doctorId, doctorBalance + money);
				accountMapper.update(doctorAccount);
			} else {
				return "balance error";
			}
			return "success";
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
