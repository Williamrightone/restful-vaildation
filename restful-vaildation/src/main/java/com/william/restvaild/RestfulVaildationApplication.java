package com.william.restvaild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class RestfulVaildationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulVaildationApplication.class, args);
	}

}
