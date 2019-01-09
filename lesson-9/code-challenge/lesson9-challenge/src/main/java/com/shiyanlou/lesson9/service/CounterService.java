package com.shiyanlou.lesson9.service;

import com.shiyanlou.lesson9.domain.ResultObject;

public interface CounterService {
	public ResultObject decr(long delta);
	public ResultObject get();
}
