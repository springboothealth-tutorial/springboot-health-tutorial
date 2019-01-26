package com.shiyanlou.lesson7.mapper;

import java.sql.Date;
import java.util.List;

import com.shiyanlou.lesson7.domain.RankList;

public interface RankListMapper {	
	List<RankList> getAll(Date collectDate);
}
