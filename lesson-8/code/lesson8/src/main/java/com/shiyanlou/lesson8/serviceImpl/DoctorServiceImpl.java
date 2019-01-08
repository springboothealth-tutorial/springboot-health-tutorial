package com.shiyanlou.lesson8.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson8.dao.DoctorMapper;
import com.shiyanlou.lesson8.domain.Doctor;
import com.shiyanlou.lesson8.service.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorMapper doctorMapper;
	
	public int insertDoctor(Doctor doctor) {
		int modifyId = doctorMapper.insert(doctor);
		return modifyId;
	}
	
	public int deleteDoctor(int id) {
		int modifyId = doctorMapper.delete(id);
		return modifyId;
	}
	
	public int updateDoctor(Doctor doctor) {
		int modifyId = doctorMapper.update(doctor);
		return modifyId;
	}
	
	public Doctor selectDoctor(int id) {
		Doctor doctor = doctorMapper.select(id);
		return doctor;
	}
}
