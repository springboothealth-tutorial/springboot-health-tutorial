package com.shiyanlou.lesson7.service;

import java.util.List;

import com.shiyanlou.lesson7.domain.UserEverydayFoodSituation;
import com.shiyanlou.lesson7.domain.UserFoodHistory;


public interface UserFoodHistoryService {

	public int insertUserFoodHistory(UserFoodHistory userFoodHistory);
	
	public List<UserEverydayFoodSituation> getAllUserFoodHistory(int userId);
}
