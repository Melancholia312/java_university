public class Employee {
    private String name;
    private Department dep;

    public Employee(String name, Department dep) {
        this.name = name;
        this.dep = dep;
    }

    public Department getDep() {
        return dep;
    }

    public String toString() {

        if (name.equals(dep.getHead().name)){
            return String.format("%s начальник отдела - %s", name, dep.getName());
        }
        return String.format("%s работает в отделе %s, начальник которого - %s", name, dep.getName(), dep.getHead().name);
    }
}