package com.gramcha.diytinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gramcha.*")
public class DiyTinyurlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiyTinyurlApplication.class, args);
	}
}
