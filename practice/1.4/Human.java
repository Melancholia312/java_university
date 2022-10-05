public class Human {

    private Name name;
    private int height;
    private Human batya;

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

    public void setBatya(Human batya) {
        this.batya = batya;
        checkBatyaSetPatronymic();
    }

}
