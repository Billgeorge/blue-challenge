package com.blue.express.character_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@EnableWebMvc
@Configuration
@ComponentScan({"com.blue.express.character_core.controller","com.blue.express.character_core"})
@SpringBootApplication
@EnableTransactionManagement
public class CharacterCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharacterCoreApplication.class, args);
	}
}
