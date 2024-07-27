import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        Student first = new Student("jamo");
        Student second = new Student("jamo1");
        Student third = new Student("Zack");
        ArrayList<Student> students = new ArrayList<>();
        students.add(third);
        students.add(first);
        students.add(second);
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
       System.out.println(first.compareTo(second));
    }
}
