public class Human {

    private Name name;
    private int height;
    private Human batya;

    public Human(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Human(Name name, int height, Human batya) {
        this(name, height);
        this.batya = batya;
        checkBatyaSetPatronymic();
    }

    private void checkBatyaSetPatronymic() {
        if (this.name.surname == null && !(this.batya.name.surname == null)) {
            this.name.surname = batya.name.surname;
        }

        if (this.name.patronymic == null && !(this.batya.name.name == null)) {
            this.name.patronymic = batya.name.name + "ович";
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
