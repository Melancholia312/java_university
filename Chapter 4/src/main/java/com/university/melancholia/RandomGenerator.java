package com.university.melancholia;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {

    private int min;
    private int max;
    private Random generator;
    private Set<Integer> cache;


    public RandomGenerator(int min, int max){
        this.min = min;
        this.max = max;
        generator = new Random();
        cache = new HashSet<>();
    }

    public int generate(){

        if (cache.size() == max - min + 1){
            cache.clear();
        }

        int generatedValue = min + generator.nextInt(max - min + 1);

        if (!cache.contains(generatedValue)){
            cache.add(generatedValue);
            return generatedValue;
        }
        return generate();
    }


    @Override
    public String toString() {
        return "RandomGenerator{" +
                "min=" + min +
                ", max=" + max +
                ", generator=" + generator +
                ", cache=" + cache +
                '}';
    }
}
