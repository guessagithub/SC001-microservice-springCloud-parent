package com.itmuch.cloud.provider.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itmuch.cloud.provider.user.entity.UserEntity;

@Mapper
public interface UserMapper {

	public UserEntity findById(Integer id);

	public List<UserEntity> userList();
	
	public List<UserEntity> findByName(String name);
	
	
}
