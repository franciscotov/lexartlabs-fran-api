package com.lexartlabs.fran.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiApplication {
	@Value("${JWT_SECRET}")
	private String jwtSecret;
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
