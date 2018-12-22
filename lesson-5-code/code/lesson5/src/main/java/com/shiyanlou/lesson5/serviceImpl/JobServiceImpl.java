package com.shiyanlou.lesson5.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson5.domain.Job;
import com.shiyanlou.lesson5.mapper.JobMapper;
import com.shiyanlou.lesson5.service.JobService;


@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobMapper jobMapper;
	
	public int insertJob(Job job) {
		int modifyId = jobMapper.insert(job);
		return modifyId;
	}
	
	public int deleteJob(int id) {
		int modifyId = jobMapper.delete(id);
		return modifyId;
	}
	
	public int updateJob(Job job) {
		int modifyId = jobMapper.update(job);
		return modifyId;
	}
	
	public Job selectJobById(int id) {
		Job job = jobMapper.selectById(id);
		return job;
	}
	
	public List<Job> selectAllJob() {
		List<Job> jobs = jobMapper.selectAll();
		return jobs;
	}
}
