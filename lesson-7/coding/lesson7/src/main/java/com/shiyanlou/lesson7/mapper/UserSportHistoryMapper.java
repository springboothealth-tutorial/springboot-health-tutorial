package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.EnergyDate;
import com.shiyanlou.lesson7.domain.UserSportHistory;

public interface UserSportHistoryMapper {

	public int insert(UserSportHistory userSportHistory);
	
	public List<UserSportHistory> getAll(int userId);
	
	public List<EnergyDate> getSumConsumeEnergy(int userId);
}
