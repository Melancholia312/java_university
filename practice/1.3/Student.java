import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String name;
    private ArrayList<Integer> marks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int ...marks) {
        this(name);
        for (int mark : marks){
            this.marks.add(mark);
        }

    }

    public Student(String name, ArrayList<Integer> marks) {
        this(name);
        this.marks = marks;


    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMark(int index, int mark) {
        this.marks.set(index, mark);
    }

    public String toString() {
        return String.format("%s: %s", name, marks);
    }

}
