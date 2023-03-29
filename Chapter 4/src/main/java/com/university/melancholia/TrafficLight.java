package com.university.melancholia;

import com.university.melancholia.Colors.Black;
import com.university.melancholia.Colors.Colorable;
import com.university.melancholia.Colors.Red;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    private Colorable currentColor;
    private final ApplicationContext applicationContext;

    public TrafficLight(@Autowired @Qualifier("black") Colorable firstColor,
                        @Autowired ApplicationContext applicationContext){
        currentColor = firstColor;
        this.applicationContext = applicationContext;
    }

    public void turnOn(){
        currentColor = applicationContext.getBean(Red.class);
    }

    public void turnOff(){
        currentColor = applicationContext.getBean(Black.class);
    }

    public void nextColor() {
        currentColor = currentColor.next();
        System.out.println(currentColor);
    }
}
