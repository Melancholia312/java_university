public class Department {

    private int id;
    private String name;
    private int id_boss;

    public Department() {}

    public Department(int id, String name, int id_boss) {
        this.id = id;
        this.name = name;
        this.id_boss = id_boss;
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

    public int getId_boss() {
        return id_boss;
    }

    public void setId_boss(int id_boss) {
        this.id_boss = id_boss;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_boss=" + id_boss +
                '}';
    }
}
