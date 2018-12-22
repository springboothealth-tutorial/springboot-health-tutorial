package com.shiyanlou.lesson5.mapper;

import java.util.List;

import com.shiyanlou.lesson5.domain.Job;


public interface JobMapper {

	Job selectById(int id);
	
	Job selectBriefById(int id);
	
	List<Job> selectAll();
	
	int insert(Job job);
	
	int update(Job job);
	
	int delete(int id);
	
}
