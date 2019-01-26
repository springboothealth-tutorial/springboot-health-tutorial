package com.shiyanlou.lesson7.service;

import java.util.List;

import com.shiyanlou.lesson7.domain.UserEverydaySportSituation;
import com.shiyanlou.lesson7.domain.UserSportHistory;

public interface UserSportHistoryService {

	public int insertUserSportHistory(UserSportHistory userSportHistory);
	
	public List<UserEverydaySportSituation> getAllUserSportHistory(int userId);
}
