package com.itmuch.cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.itmuch.cloud.gateway.zuul.filter.MyPreRequestLogFilter;
import com.itmuch.cloud.gateway.zuul.filter.MyRouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication 
{
	
	@Bean
	public MyPreRequestLogFilter myPreRequestFilter() {
		return new MyPreRequestLogFilter();
	}
	
	@Bean
	public MyRouteFilter myRouteFilter() {
		return new MyRouteFilter();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
