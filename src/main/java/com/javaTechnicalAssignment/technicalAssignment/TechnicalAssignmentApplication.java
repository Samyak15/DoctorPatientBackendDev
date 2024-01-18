package com.javaTechnicalAssignment.technicalAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.javaTechnicalAssignment.technicalAssignment")
public class TechnicalAssignmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(TechnicalAssignmentApplication.class, args);
	}
}
