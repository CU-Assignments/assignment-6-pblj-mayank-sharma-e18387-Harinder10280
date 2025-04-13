import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 55000));
        employees.add(new Employee("Bob", 25, 48000));
        employees.add(new Employee("Charlie", 35, 62000));
        employees.add(new Employee("David", 28, 50000));

        System.out.println("Sorted by Name:");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employees.forEach(System.out::println);
    }
}
