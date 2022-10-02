public class Name {
    private String name;
    private String surname;
    private String patronymic;

    public Name(String name) {
        this(name, "", "");
    }

    public Name(String name, String surname) {
        this(name, surname, "");
    }

    public Name(String name, String surname, String patronymic) {
        this.name = (name == null) ? "" : name;
        this.surname = (surname == null) ? "" : surname;
        this.patronymic = (patronymic == null) ? "" : patronymic;
    }

    public String toString() {
        return String.format("%s %s %s", name, surname, patronymic).trim();
    }
}
