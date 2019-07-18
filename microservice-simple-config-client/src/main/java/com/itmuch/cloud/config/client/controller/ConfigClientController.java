package com.itmuch.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configclient")
public class ConfigClientController  {
	
	@Value("${address}")
	private String address;
	
	@GetMapping("/address")
	public String getAddress() {
		return address;
	}

}
