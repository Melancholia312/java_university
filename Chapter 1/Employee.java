public class Employee {
    private String name;
    private Department dep;

    public Employee(String name, Department dep) {
        this.name = name;
        this.dep = dep;
        dep.addEmploy(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        if (this == this.dep.getHead()){
            this.dep.setHead(null);
        }
        this.dep.removeEmploy(this);
        this.dep = dep;
        dep.addEmploy(this);
    }

    public String toString() {

        if (this == dep.getHead()){
            return String.format("%s nachalnick - %s", name, dep.getName());
        }
        return String.format("%s ravotaet v otdele %s, nachalnick - %s", name, dep.getName(), (dep.getHead() == null) ? "None" : dep.getHead().name);
    }
}
