package com.tech_dip.movie_data_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class MovieDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataServiceApplication.class, args);
	}

}
