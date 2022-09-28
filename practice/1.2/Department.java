public class Department {

    private String name;
    private Employee head;

    public Department(String name) {
        this.name = name;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public Employee getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

}
