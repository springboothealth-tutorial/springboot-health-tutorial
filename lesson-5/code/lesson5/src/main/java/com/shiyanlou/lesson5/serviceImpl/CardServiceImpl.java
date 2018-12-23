package com.shiyanlou.lesson5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson5.domain.Card;
import com.shiyanlou.lesson5.mapper.CardMapper;
import com.shiyanlou.lesson5.service.CardService;


@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardMapper cardMapper;
	
	public int insertCard(Card card) {
		int modifyId = cardMapper.insert(card);
		return modifyId;
	}
	
	public int deleteCard(int id) {
		int modifyId = cardMapper.delete(id);
		return modifyId;
	}
	
	public int updateCard(Card card) {
		int modifyId = cardMapper.update(card);
		return modifyId;
	}
	
	public Card selectCardById(int id) {
		Card card = cardMapper.selectById(id);
		return card;
	}
	
	public List<Card> selectAllCard() {
		List<Card> cards = cardMapper.selectAll();
		return cards;
	}
	
	public List<Card> fuzzySearch(Card card) {
		List<Card> cards = cardMapper.fuzzySearch(card);
		return cards;
	}
	
	public List<Card> selectCardByLevelId(List<Integer> levels) {
		List<Card> cards = cardMapper.selectByLevelId(levels);
		return cards;
	}


}
