package com.csit321g3._idiots.sedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.csit321g3")
@EnableJpaRepositories(basePackages = "com.csit321g3.repository")
public class SedataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SedataApplication.class, args);
	}

}
