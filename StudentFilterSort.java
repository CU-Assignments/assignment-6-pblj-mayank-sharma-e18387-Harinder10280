import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 68.0),
            new Student("Charlie", 91.2),
            new Student("David", 74.9),
            new Student("Eva", 88.3)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
            .filter(s -> s.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks))
            .map(Student::getName)
            .forEach(System.out::println);
    }
}
