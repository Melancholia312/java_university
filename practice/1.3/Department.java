import java.util.ArrayList;

public class Department {

    private String name;
    private Employee head;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public void addEmploy(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmploy(Employee employee){
        this.employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }
    public Employee getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

}
