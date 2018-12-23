package com.shiyanlou.clock.service;

import com.shiyanlou.clock.domain.ResultObject;

public interface ClockService {

	public ResultObject getDiff(String firstDate, String lastDate);
}
