import java.util.Arrays;

public class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.printf("%s: meow!", name);
    }

    public void meow(int n) {
        String[] meowArr = new String[n];
        Arrays.fill(meowArr, "meow");
        System.out.printf("Cat: %s!", String.join("-", meowArr));
    }

    public String toString() {
        return String.format("Cat: %s", name);
    }

}
