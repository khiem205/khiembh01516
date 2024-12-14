import java.util.ArrayList;
import java.util.Scanner;

// Team members: Khiem - Data Input, Tuan Anh - Search & Edit Logic, Duc - System Integration
class Student {
    private String fullName;
    private int age;

    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullName + " (Age: " + age + ")";
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Team members: Khiem, Tuan Anh, Duc");
        System.out.println("Roles: Khiem - Data Input, Tuan Anh - Search & Edit Logic, Duc - System Integration");

        while (true) {
            System.out.println("\n1. Enter students  2. Find by last name  3. Edit by full name  4. Exit");
            switch (scanner.nextInt()) {
                case 1 -> addStudents();  // Khiem's responsibility
                case 2 -> findByLastName();  // Tuan Anh's responsibility
                case 3 -> editByFullName();  // Tuan Anh's responsibility
                case 4 -> { System.out.println("Goodbye!"); return; }  // Duc's responsibility
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudents() {
        System.out.print("Number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Full name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            students.add(new Student(name, age));
        }
    }

    static void findByLastName() {
        System.out.print("Last name: ");
        String lastName = scanner.next();
        students.stream()
                .filter(s -> s.getFullName().endsWith(lastName))
                .forEach(System.out::println);
    }

    static void editByFullName() {
        System.out.print("Full name to edit: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        students.stream()
                .filter(s -> s.getFullName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(s -> {
                    System.out.print("New full name: ");
                    s.setFullName(scanner.nextLine());
                    System.out.print("New age: ");
                    s.setAge(scanner.nextInt());
                }, () -> System.out.println("Student not found!"));
    }
}