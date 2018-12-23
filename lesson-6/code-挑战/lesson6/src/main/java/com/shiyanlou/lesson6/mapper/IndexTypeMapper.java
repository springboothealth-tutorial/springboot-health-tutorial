package com.shiyanlou.lesson6.mapper;

import java.util.List;

import com.shiyanlou.lesson6.domain.IndexType;


public interface IndexTypeMapper {
	
	List<IndexType> getAll();
	
	int insert(IndexType indexType);
	
	int update(IndexType indexType);
	
	int delete(int id);
	
}
