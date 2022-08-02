package com.example.BankApp3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.BankApp3.entity.Customer;



@SpringBootApplication

@EnableConfigurationProperties
@EntityScan("com.example.BankApp3")
public class BankApp3Application {
		
	@Autowired
	
	
	public static void main(String[] args) {
	  SpringApplication.run(BankApp3Application.class, args);

	}
	
	}


