package com.university.melancholia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MelancholiaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(MelancholiaApplication.class, args);

		TrafficLight trafficLight = applicationContext.getBean(TrafficLight.class);
		trafficLight.nextColor();
		trafficLight.nextColor();
		trafficLight.nextColor();

	}

}
