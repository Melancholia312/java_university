import java.util.HashMap;
import java.util.Map;

public class City {

    private HashMap<City, Integer> ways = new HashMap<>();
    private String name;

    public City(String name) {
        this.name = name;
    }

    public City(String name, HashMap<City, Integer> ways) {
        this(name);
        this.ways = ways;
    }

    public void addOneDirectionWay(City city, int wayValue){
        ways.put(city, wayValue);
    }

    public void addTwoDirectionWay(City city, int wayValue){
        ways.put(city, wayValue);
        city.addOneDirectionWay(this, wayValue);
    }

    public String toString() {
        String stringCity = "";
        for (Map.Entry<City, Integer> entry : ways.entrySet()) {
            stringCity += String.format("%s : %d; ", entry.getKey().name, entry.getValue());
        }
        return String.format("%s - {%s}", name, stringCity.trim());
    }
}
