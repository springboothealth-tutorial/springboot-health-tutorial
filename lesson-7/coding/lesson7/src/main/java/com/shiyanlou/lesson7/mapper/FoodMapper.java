package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.Food;

public interface FoodMapper {
	int insert(Food food);
	
	Food getById(int id);
	
	List<Food> getAll();
		
	int update(Food food);
	
	int delete(int id);
}
