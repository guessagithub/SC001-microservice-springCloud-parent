package com.itmuch.cloud.consumer.movie.myfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itmuch.cloud.consumer.movie.entity.UserEntity;

@FeignClient(name = "microservice-simple-provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
	
	@GetMapping(value="/user/{id}")
	public UserEntity findByIdFeign(@PathVariable("id") int id);
}
