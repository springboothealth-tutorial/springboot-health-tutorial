package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.UserIndex;

public interface UserIndexMapper {

	List<UserIndex> getById(int userId);
}
