package com.au.employee.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DatabaseConfig {
	
	@Autowired
	private DataSource dataSource;

	/**
	 * DataSource definition for database connection. Settings are read from
	 * the application.properties file (using the env object).
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/employee_schm");
		dataSource.setUsername("root");
	   	dataSource.setPassword("password");
	    
	   	return dataSource;
	}
	
	/**
	 * Declare the JPA entity manager factory.
	 */
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
	
	    entityManagerFactory.setDataSource(dataSource);
	    entityManagerFactory.setPackagesToScan("com.au.employee.model");
	
	    // Vendor adapter
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setDatabase(Database.MYSQL);
	    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
	
	    // Hibernate properties
	    Properties additionalProperties = new Properties();
	    additionalProperties.put("hibernate.hbm2ddl.auto", "update");
	    additionalProperties.put("hibernate.show_sql", "true");
	    additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    
	    //additionalProperties.put("hibernate.use_sql_comments", env.getProperty("datasource.use-sql-comments"));
	    //additionalProperties.put("hibernate.format_sql", env.getProperty("datasource.format-sql"));
	 	//additionalProperties.put("javax.persistence.validation.mode", env.getProperty("javax.persistence.validation.mode"));
	 	//additionalProperties.put("hibernate.generate_statistics", env.getProperty("datasource.generate-statistics"));
		//additionalProperties.put("org.hibernate.envers.store_data_at_delete", env.getProperty("datasource.hibernate.store_data_at_delete"));
		//additionalProperties.put("org.hibernate.envers.global_with_modified_flag", env.getProperty("datasource.hibernate.global_with_modified_flag"));
		additionalProperties.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
	    entityManagerFactory.setJpaProperties(additionalProperties);
	
	    return entityManagerFactory;
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
}
