package com.shiyanlou.lesson8.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shiyanlou.lesson8.domain.Doctor;

@Mapper
public interface DoctorMapper {

	Doctor select(int id);
	
	int insert(Doctor doctor);
	
	int update(Doctor doctor);
	
	int delete(int id);
	
}
