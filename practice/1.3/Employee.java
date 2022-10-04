public class Employee {
    private String name;
    private Department dep;

    public Employee(String name, Department dep) {
        this.name = name;
        this.dep = dep;
        dep.addEmploy(this);
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep.removeEmploy(this);
        this.dep = dep;
        dep.addEmploy(this);
    }

    public String toString() {

        if (this == dep.getHead()){
            return String.format("%s начальник отдела - %s", name, dep.getName());
        }
        return String.format("%s работает в отделе %s, начальник которого - %s", name, dep.getName(), (dep.getHead() == null) ? "None" : dep.getHead().name);
    }
}
