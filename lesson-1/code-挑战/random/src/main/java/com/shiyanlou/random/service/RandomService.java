package com.shiyanlou.random.service;

import com.shiyanlou.random.domain.ResultObject;

public interface RandomService {

	public ResultObject getRandom(int randomCounter, int randomMin, int randomMax);
	 
}
