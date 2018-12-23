package com.shiyanlou.lesson6.service;

import com.shiyanlou.lesson6.domain.IndexType;
import com.shiyanlou.lesson6.domain.PaginationObject;

public interface IndexTypeService {
	
	public PaginationObject getAllIndexType(int pageNum, int pageSize);
		
	public int insertIndexType(IndexType indexType);
	
	public int updateIndexType(IndexType indexType);
	
	public int deleteIndexType(int id);
}
