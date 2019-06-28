package com.itmuch.cloud.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication_2 
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserApplication_2.class, args);
    }
}
