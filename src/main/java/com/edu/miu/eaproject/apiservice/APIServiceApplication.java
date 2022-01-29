package com.edu.miu.eaproject.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class APIServiceApplication {


	@Bean
	public RestTemplate getRestTemplete(){

		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(APIServiceApplication.class, args);
	}
}
