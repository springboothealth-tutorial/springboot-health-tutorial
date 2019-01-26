package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.EnergyDate;
import com.shiyanlou.lesson7.domain.UserFoodHistory;

public interface UserFoodHistoryMapper {

	public int insert(UserFoodHistory userFoodHistory);
	
	public List<UserFoodHistory> getAll(int userId);
	
	public List<EnergyDate> getSumFoodEnergy(int userId);
}
