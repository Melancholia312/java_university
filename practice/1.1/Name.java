public class Name {
    String name = "";
    String surname = "";
    String patronymic = "";

    public Name(String name) {
        this.name = name;
    }

    public Name(String name, String surname) {
        this(name);
        this.surname = surname;
    }

    public Name(String name, String surname, String patronymic) {
        this(name, surname);
        this.patronymic = patronymic;
    }

    public String toString() {
        return String.format("%s %s %s", name, surname, patronymic).trim();
    }
}