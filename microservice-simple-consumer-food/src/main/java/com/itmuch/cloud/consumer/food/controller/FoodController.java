package com.itmuch.cloud.consumer.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.consumer.food.entity.UserEntity;
import com.itmuch.cloud.consumer.food.myfeign.UserFeignClient;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	UserFeignClient userFeignClient;
	
	@GetMapping("/user/findByName/{name}")
	public List<UserEntity> findByName(@PathVariable String name){
		return userFeignClient.findByName(name);
	}

}
