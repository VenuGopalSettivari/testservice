package com.telia.uniservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.telia.uniservice","com.telia.uniservice.exception"})
public class UniServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UniServiceApplication.class, args);
	}
}