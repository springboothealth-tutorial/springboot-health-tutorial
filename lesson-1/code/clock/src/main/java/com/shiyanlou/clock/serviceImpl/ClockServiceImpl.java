package com.shiyanlou.clock.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.shiyanlou.clock.domain.ResultObject;
import com.shiyanlou.clock.service.ClockService;

@Service
public class ClockServiceImpl implements ClockService{

	public ResultObject getDiff(String firstDate, String lastDate){
		ResultObject resultObject = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date formatFirstDate = null, formatLastDate = null;
		
		try {
			formatFirstDate = dateFormat.parse(firstDate);
			formatLastDate = dateFormat.parse(lastDate);
		} catch (Exception e) {
			resultObject = new ResultObject(0, "fail", "parameter error");
			return resultObject;
		}
		long day = (formatFirstDate.getTime() - formatLastDate.getTime()) / (24 * 60 * 60 * 1000);
		resultObject = new ResultObject(day, "success", "");
		return resultObject;
	}
	

}
