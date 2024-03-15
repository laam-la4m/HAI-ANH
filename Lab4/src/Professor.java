import java.util.*;
public final class Professor extends Lecturer {
    public static int countProfessors = 0;
    private int numberOfProjects;

    public Professor(String name, int age, String gender, String employeeID, int numberOfPublications, int numberOfProjects) {
        super(name, age, gender, employeeID, numberOfPublications);
        this.numberOfProjects = numberOfProjects;
        countProfessors++;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public double calculateKPI() {
        return super.calculateKPI() + numberOfProjects * 10.0;
    }
}

