public class House {

    final private int stages;

    public House(int stages) {
        if (stages < 0){
            throw new IllegalArgumentException();
        }
        this.stages = stages;
    }

    public int getStages() {
        return stages;
    }

    public String toString() {
        return (stages % 10 == 1) ? String.format("Дом с %d этажом", stages) : String.format("Дом с %d этажами", stages);
    }
}
