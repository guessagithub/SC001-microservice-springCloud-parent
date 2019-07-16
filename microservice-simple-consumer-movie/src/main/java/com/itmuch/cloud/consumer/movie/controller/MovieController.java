package com.itmuch.cloud.consumer.movie.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.consumer.movie.entity.UserEntity;
import com.itmuch.cloud.consumer.movie.myfeign.UserFeignClient;
import com.itmuch.cloud.consumer.movie.myfeign.ZuulFeignClient;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private ZuulFeignClient zuulFeignClient;

	@GetMapping("/user/feign/{id}")
	public UserEntity findByIdFeign(@PathVariable int id) {
		return userFeignClient.findByIdFeign(id);
	}

	@GetMapping("/zuul/user/feign/{id}")
	public UserEntity findByIdFeignZuul(@PathVariable int id) {
		return zuulFeignClient.findByIdFeign(id);
	}
	
	@GetMapping("/user/hystrix/{id}")
	public UserEntity findByIdHystrix(@PathVariable int id) {
		return userFeignClient.findByIdFeign(id);
	}
	
	public UserEntity findByIdFeignFallback(int id) {
		UserEntity user = new UserEntity();
		user.setId(-1l);
		user.setAge(20);
		user.setUsername("account-1");
		user.setName("默认用户（方法体注解）");
		user.setBalance(new BigDecimal(9999));
		return user;
	}
	
	@GetMapping("/user/{id}")
	public UserEntity findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-simple-provider-user/user/"+id, UserEntity.class);
	}
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo(){
		return this.discoveryClient.getInstances("microservice-simple-provider-user");
	}
	
}
