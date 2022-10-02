public class House {

    final private int stages;

    public House(int stages) {
        this.stages = stages;
    }

    public String toString() {
        return (stages % 10 == 1) ? String.format("Дом с %d этажом", stages) : String.format("Дом с %d этажами", stages);
    }
}