import java.util.*;
public class Lecturer extends Person implements KPIEvaluator {
    public String employeeID;
    private int numberOfPublications;

    public Lecturer(String name, int age, String gender, String employeeID, int numberOfPublications) {
        super(name, age, gender);
        this.employeeID = employeeID;
        this.numberOfPublications = numberOfPublications;
    }

    @Override
    public String getRole() {
        return "Lecturer";
    }

    @Override
    public double calculateKPI() {
        return numberOfPublications * 7.0;
    }
}

