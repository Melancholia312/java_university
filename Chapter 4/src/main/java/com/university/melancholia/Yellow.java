package com.university.melancholia;

import com.university.melancholia.Colors.Colorable;
import com.university.melancholia.Colors.Green;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("yellow")
public class Yellow implements Colorable {

    public static Colorable color = new Yellow();

    @Override
    public Colorable next() {
        return Green.color;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
