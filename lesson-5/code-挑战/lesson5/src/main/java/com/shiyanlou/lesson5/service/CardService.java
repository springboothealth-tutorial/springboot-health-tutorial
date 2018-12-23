package com.shiyanlou.lesson5.service;

import java.util.List;

import com.shiyanlou.lesson5.domain.Card;

public interface CardService {
	
	public int insertCard(Card card);
	
	public int deleteCard(int id);
	
	public int updateCard(Card card);
	
	public Card selectCardById(int id);
	
	public List<Card> selectAllCard();
	
	public List<Card> fuzzySearch(Card card);

	public List<Card> selectCardByLevelId(List<Integer> levels);

}
