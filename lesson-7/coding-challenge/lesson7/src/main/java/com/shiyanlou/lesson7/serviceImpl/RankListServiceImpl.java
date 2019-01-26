package com.shiyanlou.lesson7.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson7.domain.RankList;
import com.shiyanlou.lesson7.mapper.RankListMapper;
import com.shiyanlou.lesson7.service.RankListService;

@Service
public class RankListServiceImpl implements RankListService{

	@Autowired
	private RankListMapper rankListMapper;

	@Override
	public List<RankList> getAllRankList(Date collectDate) {
		List<RankList> rankLists = rankListMapper.getAll(collectDate);
		return rankLists;
	}
	
}
