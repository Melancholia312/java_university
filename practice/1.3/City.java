import java.util.HashMap;

public class City {

    private HashMap<String, Integer> ways;
    private String name;

    public City(String name) {
        this.name = name;
    }

    public City(String name, HashMap<String, Integer> ways) {
        this(name);
        this.ways = ways;
    }

    public String toString() {
        return String.format("%s: %s", name, ways);
    }
}
