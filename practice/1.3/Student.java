import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> marks;

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public Student(String name, Integer ...marks) {
        this(name, new ArrayList<>(Arrays.asList(marks)));
    }

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = new ArrayList<>(marks);
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMark(int index, int mark) {
        this.marks.set(index, mark);
    }

    public String toString() {
        return String.format("%s: %s", name, marks);
    }

}
