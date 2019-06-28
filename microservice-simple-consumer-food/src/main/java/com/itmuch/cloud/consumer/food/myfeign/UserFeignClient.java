package com.itmuch.cloud.consumer.food.myfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itmuch.cloud.consumer.food.entity.UserEntity;

@FeignClient(name = "microservice-simple-provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
	
	@GetMapping("/user/findByName/{name}")
	public List<UserEntity> findByName(@PathVariable("name") String name);

}
