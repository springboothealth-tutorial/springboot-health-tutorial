package com.shiyanlou.lesson5.mapper;

import java.util.List;

import com.shiyanlou.lesson5.domain.Card;


public interface CardMapper {

	Card selectById(int id);
	
	List<Card> fuzzySearch(Card card);
	
	List<Card> selectAll();
	
	List<Card> selectByLevelId(List<Integer> levels);
	
	int insert(Card job);
	
	int update(Card job);
	
	int delete(int id);
	
}
