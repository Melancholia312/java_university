package com.university.melancholia.Colors;

import com.university.melancholia.Yellow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("red")
public class Red implements Colorable {

    public static Colorable color = new Red();
    @Override
    public Colorable next() {
        return Yellow.color;
    }

    @Override
    public String toString() {
        return "Red";
    }
}
