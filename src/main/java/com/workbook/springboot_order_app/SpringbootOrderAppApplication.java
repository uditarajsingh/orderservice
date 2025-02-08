package com.workbook.springboot_order_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootOrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOrderAppApplication.class, args);
	}

}
