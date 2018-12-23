package com.shiyanlou.lesson6.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiyanlou.lesson6.domain.IndexType;
import com.shiyanlou.lesson6.domain.PaginationObject;
import com.shiyanlou.lesson6.mapper.IndexTypeMapper;
import com.shiyanlou.lesson6.service.IndexTypeService;



@Service
public class IndexTypeServiceImp implements IndexTypeService{

	@Autowired
	private IndexTypeMapper indexTypeMapper;	
	
	public PaginationObject getAllIndexType(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<IndexType> userIndexs = indexTypeMapper.getAll();
		PageInfo<IndexType> appsPageInfo = new PageInfo<>(userIndexs);
		long total = appsPageInfo.getTotal();
		PaginationObject paginationObject = new PaginationObject(userIndexs, pageNum, pageSize, total);
		return paginationObject;
	}
	
	public int insertIndexType(IndexType indexType) {
		int modifyId = indexTypeMapper.insert(indexType);
		return modifyId; 
	}
	
	public int updateIndexType(IndexType indexType) {
		int modifyId = indexTypeMapper.update(indexType);
		return modifyId;
	}
	
	public int deleteIndexType(int id) {
		int modifyId = indexTypeMapper.delete(id);
		return modifyId;
	}
	
}
