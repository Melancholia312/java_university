package com.university.melancholia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MelancholiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelancholiaApplication.class, args);
		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(Config.class);


	}

}
