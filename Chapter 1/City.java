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

    public HashMap<City, Integer> getWays() {
        return new HashMap<>(ways);
    }

    public void setWays(HashMap<City, Integer> ways) {
        this.ways = new HashMap<>(ways);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (ways != null ? !ways.equals(city.ways) : city.ways != null) return false;
        return name != null ? name.equals(city.name) : city.name == null;
    }

    @Override
    public int hashCode() {
        int result = ways != null ? ways.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String toString() {
        String stringCity = "";
        for (Map.Entry<City, Integer> entry : ways.entrySet()) {
            stringCity += String.format("%s : %d; ", entry.getKey().name, entry.getValue());
        }
        return String.format("%s - {%s}", name, stringCity.trim());
    }
}
