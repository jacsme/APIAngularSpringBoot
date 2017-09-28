# APIAngularSpringBoot
This is my project that showcase Spring Boot, AngularJS, Restful and Hibernate (Java 1.8)

	The database that was used is MySQL 6.3.

	##Please do this to set up the project. 

	1. Import the project in eclipse convert the project in Maven
	2. Change the Java Compiler/Build Path to Java1.8, change the Project Facets as well to Java 1.8
	4. Select and click EmployeeApplication localted in this package com.au.employee.application. Right click and
	 select run as Java Application.


	##Implement the database :

	1. Copy the database scripts from src/main/resources. Run them to your MYSql Schema.
	2. Change your database config in application.properties, the one configured is my local mySQL database.
		spring.datasource.url=jdbc:mysql://127.0.0.1:3306/employee_schm

	Run the eclipse project, once it is up and running you may type in internet explorer/chrome
	http://localhost:8080/APIEmployeeSpringBoot
