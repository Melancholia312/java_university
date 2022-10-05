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
    
        public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String toString() {
        return String.format("%s %s %s", name, surname, patronymic).trim();
    }
}
