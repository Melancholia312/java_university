public class Human {

    private String name;
    private int height;

    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String toString() {
        return String.format("%s, height: %d", name, height);
    }

}
