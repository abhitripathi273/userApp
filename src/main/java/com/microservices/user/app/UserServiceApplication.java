package com.microservices.user.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableEurekaClient
@EnableHystrix
public class UserServiceApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("UserService Application : Started");
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public Docket userServiceApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.microservices.user.app")).build();
	}
}
