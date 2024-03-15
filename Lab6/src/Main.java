import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (n < 3 || n > 10) {
            System.out.print("Enter a number of persons (3-10): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                scanner.next(); // clear the invalid input
            }
        }

        PersonManager pm = new PersonManager();

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Type (1-Student, 2-Teacher, 3-Staff): ");
            int type = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Age: ");
            int age = scanner.nextInt();

            switch (type) {
                case 1: // Student
                    System.out.println("GPA: ");
                    double gpa = scanner.nextDouble();
                    pm.addPerson(new Student(name, age, gpa));
                    break;
                case 2: // Teacher
                    System.out.println("Salary: ");
                    double salary = scanner.nextDouble();
                    pm.addPerson(new Teacher(name, age, salary));
                    break;
                case 3: // Staff
                    scanner.nextLine(); // Consume newline
                    System.out.println("Role: ");
                    String role = scanner.nextLine();
                    pm.addPerson(new Staff(name, age, role));
                    break;
                default:
                    System.out.println("Invalid type, skipping.");
            }
        }

        System.out.println("\n--- Persons List ---");
        pm.displayPersons();
        System.out.println("\nTotal Salary of Teachers: " + pm.calculateTotalSalary());
    }
}
