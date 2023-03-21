package com.university.melancholia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class Config {

    @Bean
    String helloWorld(){
        return "Hello world";
    }

    @Bean
    int random(){
        int min = 0;
        int max = 99;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1);
    }

    @Bean
    @Lazy
    Date startDate(){
        return new Date();
    }

    @Bean
    @Scope("prototype")
    boolean checkRange(Integer intValue){
        Predicate<Integer> checkMore = integer -> integer >= 2;
        Predicate<Integer> checkLess = integer -> integer <= 5;
        return checkMore.and(checkLess).test(intValue);
    }

    @Bean
    int max(){
        return 100;
    }

    @Bean
    int min(){
        return 0;
    }
}
