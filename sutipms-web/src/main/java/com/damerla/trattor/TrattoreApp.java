package com.damerla.trattor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages= {"com.damerla.trattor"})
public class TrattoreApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TrattoreApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TrattoreApp.class, args);
	}

}
