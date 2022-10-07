import java.util.HashMap;
import java.util.Map;

public class City {

    private HashMap<City, Integer> ways;
    private String name;

    public City(String name) {
        this(name, new HashMap<>());
    }

    public City(String name, HashMap<City, Integer> ways) {
        this.name = name;
        this.ways = new HashMap<>(ways);
    }

    public void addOneDirectionWay(City city, int wayValue){
        city.ways.remove(this);
        ways.put(city, wayValue);
    }

    public void addTwoDirectionWay(City city, int wayValue){
        city.ways.put(this, wayValue);
        ways.put(city, wayValue);
    }

    public void removeWay(City city){
        city.ways.remove(this);
        ways.remove(city);
    }

    public String toString() {
        String stringCity = "";
        for (Map.Entry<City, Integer> entry : ways.entrySet()) {
            stringCity += String.format("%s : %d; ", entry.getKey().name, entry.getValue());
        }
        return String.format("%s - {%s}", name, stringCity.trim());
    }
}
