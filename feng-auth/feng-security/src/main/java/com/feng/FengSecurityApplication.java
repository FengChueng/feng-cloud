package com.feng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaAuditing
@EntityScan(basePackages = "com.feng.pojo")
@EnableJpaRepositories(basePackages = { "com.feng.repository" })
@ComponentScan(value="com.feng")
@SpringBootApplication
public class FengSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FengSecurityApplication.class, args);
	}

}

