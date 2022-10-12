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

        checkEmptyFields();
    }

    private void checkEmptyFields(){
        if (this.name.isEmpty() && this.surname.isEmpty() && this.patronymic.isEmpty()){
            throw new IllegalArgumentException();
        }
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
        if (name == null){
            setName("");
        }
        this.name = name;
        checkEmptyFields();
    }

    public void setSurname(String surname) {
        if (surname == null){
            setSurname("");
        }
        this.surname = surname;
        checkEmptyFields();
    }

    public void setPatronymic(String patronymic) {
        if (patronymic == null){
            setPatronymic("");
        }
        this.patronymic = patronymic;
        checkEmptyFields();
    }

    public String toString() {
        return String.format("%s %s %s", name, surname, patronymic).trim();
    }
}
