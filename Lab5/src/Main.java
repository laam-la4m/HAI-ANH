
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Staff> staffList = new ArrayList<>();
    private static final HashMap<String, Fresher> fresherMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inputStaffList();
        displayStaffWithExperienceOverFiveYears();
        System.out.println("Total number of Leaders: " + Leader.countLeader);
        findFresherByID();
        writeStaffListToCSV("staffList.csv");
    }

    private static void inputStaffList() {
        while (true) {
            System.out.print("Enter type (fr/js/le) or '#' to stop: ");
            String type = scanner.nextLine();
            if ("#".equals(type)) {
                break;
            }

            System.out.print("Employee ID: ");
            String employeeID = scanner.nextLine();
            System.out.print("Card ID: ");
            String cardID = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Skill: ");
            String skill = scanner.nextLine();

            switch (type.toLowerCase()) {
                case "fr":
                    System.out.print("Quality (0.0-1.0): ");
                    double quality = Double.parseDouble(scanner.nextLine());
                    System.out.print("Deadline (true/false): ");
                    boolean deadline = Boolean.parseBoolean(scanner.nextLine());
                    Fresher fresher = new Fresher(employeeID, cardID, name, skill, quality, deadline);
                    staffList.add(fresher);
                    fresherMap.put(employeeID, fresher);
                    break;
                case "js":
                    System.out.print("Years of Experience: ");
                    int years = Integer.parseInt(scanner.nextLine());
                    staffList.add(new Junior_Senior(employeeID, cardID, name, skill, 0.5, true, years));
                    break;
                case "le":
                    System.out.print("Project Score (1.0-10.0): ");
                    double projectScore = Double.parseDouble(scanner.nextLine());
                    staffList.add(new Leader(employeeID, cardID, name, skill, 0.5, true, 5, projectScore));
                    break;
                default:
                    System.out.println("Invalid type, try again.");
                    break;
            }
        }
    }

    private static void displayStaffWithExperienceOverFiveYears() {
        for (Staff staff : staffList) {
            if (staff instanceof Junior_Senior && ((Junior_Senior) staff).getExpYear() > 5) {
                System.out.println(staff.name + " has more than 5 years of experience.");
            }
        }
    }

    private static void findFresherByID() {
        System.out.print("Enter Fresher Employee ID to find: ");
        String id = scanner.nextLine();
        Fresher fresher = fresherMap.get(id);
        if (fresher != null) {
            System.out.println("Fresher found: " + fresher.name);
        } else {
            System.out.println("Fresher not found.");
        }
    }

    private static void writeStaffListToCSV(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Staff staff : staffList) {
                String line = staff.employeeID + "," + staff.cardID + "," + staff.name + "," + staff.skill + "," + staff.getLevel();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Staff list written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
