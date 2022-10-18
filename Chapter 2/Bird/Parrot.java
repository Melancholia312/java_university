package Bird;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parrot extends Bird {

    private String text;

    public Parrot(String text){
        this.text = text == null ? "" : text;
    }

    @Override
    public void sing() {
        List<String> letters = Arrays.asList(text.split(""));
        Collections.shuffle(letters);
        System.out.println(String.join("", letters));
    }

}
