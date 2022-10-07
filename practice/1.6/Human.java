public class Human {

    private Name name;
    private int height;
    private final Human batya;

    public Human(Human human){
        this(human.name, human.height, human.batya);
    }

    public Human(String name, int height) {
        this(new Name(name), height, null);
    }

    public Human(String name, int height, Human batya) {
        this(new Name(name), height, batya);
    }
    public Human(Name name, int height) {
        this(name, height, null);
    }

    public Human(Name name, int height, Human batya) {

        if (height < 0 || height > 500){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.height = height;
        this.batya = batya;
        checkBatyaSetPatronymic();
    }

    private void checkBatyaSetPatronymic() {

        if (this.batya == null){
            return;
        }

        if (this.name.getSurname().isEmpty() && !(this.batya.name.getSurname().isEmpty())) {
            this.name.setSurname(batya.name.getSurname());
        }
        if (this.name.getPatronymic().isEmpty() && !(this.batya.name.getName().isEmpty())) {
            this.name.setPatronymic(batya.name.getName() + "ович");
        }
    }

    public String toString() {
        return String.format("%s, рост: %d", name, height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 500){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public Human getBatya() {
        return new Human(batya);
    }

    public Name getName() {
        return name;
    }
}
