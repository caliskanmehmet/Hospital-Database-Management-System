package com.group25.ebnisina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Disabled Spring Security for now
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaRepositories(basePackages="com.group25.ebnisina")
public class EbnisinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbnisinaApplication.class, args);
	}

}
