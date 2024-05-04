package com.csuwebeng.opendiseaseapp;

import com.csuwebeng.opendiseaseapp.services.CovidAPIDataService;
import com.csuwebeng.opendiseaseapp.services.impl.CovidAPIDataServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.csuwebeng.opendiseaseapp.services.impl.CustomUserDetailsService;

@EnableScheduling
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication()
public class OpendiseaseappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpendiseaseappApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}


}
