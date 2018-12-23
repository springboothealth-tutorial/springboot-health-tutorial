package com.shiyanlou.lesson5.mapper;

import java.util.List;

import com.shiyanlou.lesson5.domain.Hobby;


public interface HobbyMapper {

	Hobby selectById(int id);

	Hobby selectBriefById(int id);

	List<Hobby> selectAll();
	
	int insert(Hobby hobby);
	
	int update(Hobby hobby);
	
	int delete(int id);
	
}
