package com.project.tan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.project.tan")
public class TanSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TanSpringApplication.class, args);
	}
}
