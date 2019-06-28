package com.itmuch.cloud.consumer.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.consumer.books.entity.UserEntity;
import com.itmuch.cloud.consumer.books.myfeign.UserFeignClient;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/user/userList")
	public List<UserEntity> userList(){
		return userFeignClient.userList();
	}
	
}
