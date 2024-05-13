package com.ptit.Hirex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HirexApplication {

	public static void main(String[] args) {
		SpringApplication.run(HirexApplication.class, args);
	}

}
