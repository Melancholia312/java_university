import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Employee head;
    private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }


    public void addEmploy(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmploy(Employee employee){
        this.employees.remove(employee);
    }

    public List<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }
    
    public Employee getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

}
