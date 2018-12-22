package com.shiyanlou.random.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shiyanlou.random.domain.ResultObject;
import com.shiyanlou.random.service.RandomService;

@Service
public class RandomServiceImpl implements RandomService {

	public ResultObject getRandom(int randomCounter, int randomMin, int randomMax) {
		ResultObject resultObject = null;
		if (randomCounter <= 0 || randomMax <= randomMin) {
			resultObject = new ResultObject(null, 400, "parameter error");
			return resultObject;
		} 
		List<Double> results = new ArrayList<>(randomCounter);
		for(int i = 0; i < randomCounter; i++) {
			double result = Math.floor(Math.random() * (randomMax - randomMin) + randomMin);
			results.add(result);
		}
		
		resultObject = new ResultObject(results, 200, "success");
		return resultObject;
	}

}
