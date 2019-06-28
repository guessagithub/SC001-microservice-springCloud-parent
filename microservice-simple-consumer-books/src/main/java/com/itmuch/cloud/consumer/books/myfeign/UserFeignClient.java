package com.itmuch.cloud.consumer.books.myfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.itmuch.cloud.consumer.books.entity.UserEntity;

@FeignClient(name = "microservice-simple-provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
	
	@GetMapping("/user/list")
	public List<UserEntity> userList();

}
