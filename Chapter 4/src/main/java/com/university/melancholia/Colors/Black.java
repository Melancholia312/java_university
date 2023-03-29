package com.university.melancholia.Colors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("black")
public class Black implements Colorable {

    public static Colorable color = new Black();
    @Override
    public Colorable next() {
        return Black.color;
    }

    @Override
    public String toString() {
        return "Black";
    }
}
