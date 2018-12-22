package com.shiyanlou.lesson5.service;

import java.util.List;

import com.shiyanlou.lesson5.domain.Job;

public interface JobService {
	
	public int insertJob(Job job);
	
	public int deleteJob(int id);
	
	public int updateJob(Job job);
	
	public Job selectJobById(int id);
	
	public List<Job> selectAllJob();

}
