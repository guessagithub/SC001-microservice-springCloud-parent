package com.itmuch.cloud.consumer.movie.myfeign;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itmuch.cloud.consumer.movie.entity.UserEntity;

import feign.hystrix.FallbackFactory;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
	
	private static final Logger log = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		
		return new UserFeignClient() {
			
			@Override
			public UserEntity findByIdFeign(int id) {
				// 日志最好放在各个fallback方法中，不要直接放在create方法中
				// 否则在引用启动时，就会打印该日志
				
				UserFeignClientFallbackFactory.log.error("=========== fallback reason is :", cause);

				UserEntity user = new UserEntity();
				user.setId(-1l);
				user.setAge(20);
				user.setUsername("account-1");
				user.setName("默认用户（打印fallback原因）");
				user.setBalance(new BigDecimal(9999));
				
				return user;
			}
		};
		
	}

}
