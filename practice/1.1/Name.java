public class Name {
    String name;
    String surname;
    String patronymic;

    public Name(String name) {
        this(name, "", "");
    }

    public Name(String name, String surname) {
        this(name, surname, "");
    }

    public Name(String name, String surname, String patronymic) {
        if (name == null) {
            this.name = "";
        } 
        if (surname == null) {
            this.surname = "";
        } 
        if (patronymic == null) {
            this.patronymic = "";
        } 
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String toString() {
        return String.format("%s %s %s", name == null ? "" : name, surname == null ? "" : surname, patronymic == null ? "" : patronymic).trim();
    }
}
