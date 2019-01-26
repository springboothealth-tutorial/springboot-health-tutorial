package com.shiyanlou.lesson7.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson7.domain.RankList;
import com.shiyanlou.lesson7.domain.ResultObject;
import com.shiyanlou.lesson7.service.RankListService;

@RestController
@RequestMapping("api/v1/ranklist")
public class RankListController {

	@Autowired
	private RankListService rankListService;
	
	@GetMapping("get")
	public ResultObject getAllFood(@RequestParam Date collectDate) {
		List<RankList> rankLists = rankListService.getAllRankList(collectDate);
		ResultObject resultObject = new ResultObject(200, "success", rankLists);

		return resultObject;
	}
}
