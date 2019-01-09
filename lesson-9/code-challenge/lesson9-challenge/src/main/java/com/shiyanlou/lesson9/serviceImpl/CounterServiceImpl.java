package com.shiyanlou.lesson9.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson9.domain.ResultObject;
import com.shiyanlou.lesson9.service.CounterService;
import com.shiyanlou.lesson9.util.RedisUtil;


@Service
public class CounterServiceImpl implements CounterService{
	
	@Autowired
	private RedisUtil redisUtil;
	
	private static final String KEY = "COUNTER";

	@Override
	public ResultObject decr(long delta) {
		ResultObject resultObject = new ResultObject();
		try {
			redisUtil.decr(KEY, delta);
		} catch (Exception e) {
			resultObject.setCode(-1);
			resultObject.setMsg(e.getMessage());
		}
		Object object = redisUtil.get(KEY);
		resultObject.setCode(0);
		resultObject.setMsg("success");
		resultObject.setResult(object);
		return resultObject;
	}

	@Override
	public ResultObject get() {
		Object object = redisUtil.get(KEY);
		ResultObject resultObject = new ResultObject(0, "success", object);
		return resultObject;
	}
}
