package com.university.melancholia.Colors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("green")
public class Green implements Colorable {

    public static Colorable color = new Green();

    @Override
    public Colorable next() {
        return Red.color;
    }

    @Override
    public String toString() {
        return "Green";
    }
}
