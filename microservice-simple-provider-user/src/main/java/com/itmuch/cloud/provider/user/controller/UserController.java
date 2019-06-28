package com.itmuch.cloud.provider.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.provider.user.entity.UserEntity;
import com.itmuch.cloud.provider.user.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/{id}")
	public UserEntity findById(@PathVariable Integer id) {
		UserEntity userEntity = userMapper.findById(id);
		userEntity.setDesc("我是User服务提供者【1】，调用了接口【findById】。");
		System.out.println("我是User服务提供者【1】，调用了接口【findById】。");
		return userEntity;
	}
	
	@GetMapping("/list")
	public List<UserEntity> userList() {
		List<UserEntity> userList = userMapper.userList();
		for(UserEntity user : userList) {
			user.setDesc("我是User服务提供者【1】，调用了接口【userList】。");
			System.out.println("我是User服务提供者【1】，调用了接口【userList】。");
		}
		return userList;
	}
	
	@GetMapping("/findByName/{name}")
	public List<UserEntity> findByName(@PathVariable String name) {
		List<UserEntity> userList = userMapper.findByName(name);
		for(UserEntity user : userList) {
			user.setDesc("我是User服务提供者【1】，调用了接口【findByName】。");
			System.out.println("我是User服务提供者【1】，调用了接口【findByName】。");
		}
		return userList;
	}
	
	
}
