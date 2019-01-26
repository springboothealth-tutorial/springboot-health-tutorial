package com.shiyanlou.lesson7.service;

import java.sql.Date;
import java.util.List;
import com.shiyanlou.lesson7.domain.RankList;

public interface RankListService {
	public List<RankList> getAllRankList(Date collectDate);
}
