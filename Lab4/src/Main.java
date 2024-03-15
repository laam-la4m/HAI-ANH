import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Person> persons = inputPersonList();
        displayPersonList(persons);
        displayProfessorCount();
    }

    private static ArrayList<Person> inputPersonList() {
        ArrayList<Person> persons = new ArrayList<>();
        String choice;
        while (true) {
            System.out.println("\nChoose the type of person to add:");
            System.out.println("1. Teaching Assistant (ta)");
            System.out.println("2. Lecturer (lec)");
            System.out.println("3. Professor (prof)");
            System.out.println("Or type 'exit' to finish.");
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("exit")) break;

            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Employee ID: ");
            String employeeID = scanner.nextLine();

            switch (choice) {
                case "1": // TA
                    System.out.print("Number of Courses: ");
                    int courses = Integer.parseInt(scanner.nextLine());
                    persons.add(new TeachingAssistant(name, age, gender, employeeID, courses));
                    break;
                case "2": // Lecturer
                    System.out.print("Number of Publications: ");
                    int publications = Integer.parseInt(scanner.nextLine());
                    persons.add(new Lecturer(name, age, gender, employeeID, publications));
                    break;
                case "3": // Professor
                    System.out.print("Number of Publications: ");
                    int profPublications = Integer.parseInt(scanner.nextLine());
                    System.out.print("Number of Projects: ");
                    int projects = Integer.parseInt(scanner.nextLine());
                    persons.add(new Professor(name, age, gender, employeeID, profPublications, projects));
                    break;
                default:
                    System.out.println("Invalid choice, please try again."); // Ensures users are aware of incorrect input
                    break;
            }
        }
        return persons;
    }

    private static void displayPersonList(ArrayList<Person> persons) {
        System.out.println("\nPerson List:");
        for (Person person : persons) {
            System.out.println("------------------------------");
            System.out.println("Name: " + person.name);
            System.out.println("Age: " + person.age);
            System.out.println("Gender: " + person.gender);
            System.out.println("Role: " + person.getRole());
            System.out.println("KPI: " + ((KPIEvaluator) person).calculateKPI());
        }
        if (persons.isEmpty()) {
            System.out.println("No persons to display.");
        }
    }

    private static void displayProfessorCount() {
        System.out.println("------------------------------");
        System.out.println("Total number of Professors: " + Professor.countProfessors);
    }
}
