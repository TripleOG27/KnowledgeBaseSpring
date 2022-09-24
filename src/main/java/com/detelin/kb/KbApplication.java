package com.detelin.kb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class })
@EnableAutoConfiguration
@EnableJpaRepositories("com.detelin.kb.*")
@EntityScan("com.detelin.kb.domain.*")
@ComponentScan("com.detelin.kb.*")
public class KbApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbApplication.class, args);
	}

}
