package com.shiyanlou.lesson5.service;

import java.util.List;

import com.shiyanlou.lesson5.domain.Hobby;

public interface HobbyService {
	
	public int insertHobby(Hobby hobby);
	
	public int deleteHobby(int id);
	
	public int updateHobby(Hobby hobby);
	
	public Hobby selectHobbyById(int id);
	
	public List<Hobby> selectAllHobby();

}
