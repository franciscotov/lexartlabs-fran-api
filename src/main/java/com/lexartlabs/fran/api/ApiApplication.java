package com.lexartlabs.fran.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiApplication {
	@Value("${JWT_SECRET}")
	private String jwtSecret;
	public static void main(String[] args) {
		System.out.println("Hello World.......................................................................................");
		System.out.println("Hello World.......................................................................................");
		System.out.println("Hello World.......................................................................................");
		System.out.println("Hello World.......................................................................................");
		System.out.println("Hello World.......................................................................................");
		System.out.println("Hello World.......................................................................................");
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000/", "http://localhost:3000", "http://localhost","localhost", "localhost:3000", "localhost:4200", "*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
