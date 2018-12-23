package com.shiyanlou.lesson5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson5.domain.Hobby;
import com.shiyanlou.lesson5.mapper.HobbyMapper;
import com.shiyanlou.lesson5.service.HobbyService;


@Service
public class HobbyServiceImpl implements HobbyService{

	@Autowired
	private HobbyMapper hobbyMapper;
	
	public int insertHobby(Hobby hobby) {
		int modifyId = hobbyMapper.insert(hobby);
		return modifyId;
	}
	
	public int deleteHobby(int id) {
		int modifyId = hobbyMapper.delete(id);
		return modifyId;
	}
	
	public int updateHobby(Hobby hobby) {
		int modifyId = hobbyMapper.update(hobby);
		return modifyId;
	}
	
	public Hobby selectHobbyById(int id) {
		Hobby hobby = hobbyMapper.selectById(id);
		return hobby;
	}
	
	public List<Hobby> selectAllHobby() {
		List<Hobby> hobbys = hobbyMapper.selectAll();
		return hobbys;
	}
}
