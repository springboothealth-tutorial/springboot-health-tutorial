package com.shiyanlou.lesson5.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.shiyanlou.lesson5.domain.Job;
import com.shiyanlou.lesson5.domain.ResultObject;
import com.shiyanlou.lesson5.service.JobService;

@RestController
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@PostMapping("add")
	public ResultObject add(@RequestBody Job job) {
		int modifyId = jobService.insertJob(job);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	

	@DeleteMapping("delete/{id}")
	public ResultObject delete(@PathVariable int id) {
		int modifyId = jobService.deleteJob(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@PutMapping("modify")
	public ResultObject modify(@RequestBody Job job) {
		int modifyId = jobService.updateJob(job);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("find/{id}")
	public ResultObject find(@PathVariable int id) {
		Job job = jobService.selectJobById(id);
		Map<String, Job> map = new HashMap<>();
		map.put("job", job);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("findAll")
	public ResultObject findAll() {
		List<Job> jobs = jobService.selectAllJob();
		Map<String, List<Job>> map = new HashMap<>();
		map.put("job", jobs);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
}