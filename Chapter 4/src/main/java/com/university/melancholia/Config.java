package com.university.melancholia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class Config {

    @Bean
    String helloWorld(){
        return "Hello world";
    }

    @Bean
    @Lazy
    Date startDate(){
        return new Date();
    }


    //REVIEWS

    @Bean
    Feedback goodReview(){
        return new Feedback("Very good", 4);
    }

    @Bean
    Feedback midReview(){
        return new Feedback("Mid", 3);
    }

    @Scope("prototype")
    @Bean
    Feedback hardToSayReview(@Autowired @Qualifier("random") int random){
        return new Feedback("Hard To Say", random);
    }

    @Bean
    Feedback bestFeedback(List<Feedback> feedbackList){
        return feedbackList.stream()
                .max(Comparator.comparing(Feedback::getMark))
                .orElseThrow(NoSuchElementException::new);
    }

    //RANDOM

    @Bean
    @Qualifier("max")
    int max(){
        return 3;
    }

    @Bean
    @Qualifier("min")
    int min(){
        return 1;
    }

    @Bean
    RandomGenerator randomGenerator(@Autowired @Qualifier("min") int min, @Autowired @Qualifier("max") int max){
        return new RandomGenerator(min, max);
    }

    @Bean
    @Qualifier("random")
    int random(@Autowired RandomGenerator randomGenerator){
        return randomGenerator.generate();
    }

    //STUDENT

    @Bean
    @Scope("prototype")
    @Qualifier("range")
    Predicate<Integer> range(){
        return integer -> integer >=2 && integer <=5;
    }

    @Bean
    Student student(@Autowired Predicate<Integer> range){
        return new Student(range);
    }

    @Bean
    StudentBuilder studentBuilder(@Autowired Predicate<Integer> range){
        return new StudentBuilder(range);
    }


}
