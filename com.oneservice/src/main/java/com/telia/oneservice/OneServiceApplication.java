package com.telia.oneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.telia.oneservice","com.telia.oneservice.exception"})
public class OneServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneServiceApplication.class, args);
	}
}