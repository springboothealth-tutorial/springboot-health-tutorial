package com.shiyanlou.lesson8.service;

import com.shiyanlou.lesson8.domain.Doctor;

public interface DoctorService {
	
	public int insertDoctor(Doctor doctor);
	
	public int deleteDoctor(int id);
	
	public int updateDoctor(Doctor doctor);
	
	public Doctor selectDoctor(int id);
	
}
