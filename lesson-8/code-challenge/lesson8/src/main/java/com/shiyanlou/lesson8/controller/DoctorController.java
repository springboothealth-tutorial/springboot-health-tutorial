package com.shiyanlou.lesson8.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson8.domain.Doctor;
import com.shiyanlou.lesson8.domain.ResultObject;
import com.shiyanlou.lesson8.service.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("add")
	public ResultObject add(@RequestBody Doctor doctor) {
		int modifyId = doctorService.insertDoctor(doctor);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	

	@DeleteMapping("delete")
	public ResultObject delete(@RequestParam int id) {
		int modifyId = doctorService.deleteDoctor(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@PutMapping("modify")
	public ResultObject modify(@RequestBody Doctor doctor) {
		int modifyId = doctorService.updateDoctor(doctor);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("find")
	public ResultObject find(@RequestParam int id) {
		Doctor doctor = doctorService.selectDoctor(id);
		Map<String, Doctor> map = new HashMap<>();
		map.put("doctor", doctor);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
}