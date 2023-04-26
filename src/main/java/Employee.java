public class Employee {

    private int id;
    private String name;
    private int id_dep;

    public Employee(){}

    public Employee(int id, String name, int id_dep) {
        this.id = id;
        this.name = name;
        this.id_dep = id_dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_dep=" + id_dep +
                '}';
    }
}
