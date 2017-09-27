package com.au.employee.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import com.au.employee.controller.EmployeesController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.au"} , exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages = {
		"com.au.employee.config",
        "com.au.employee.service",
        "com.au.employee.repository",
        "com.au.employee.model"}, basePackageClasses = EmployeesController.class)
@EnableTransactionManagement
public class EmployeeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmployeeApplication.class);
    }
}


