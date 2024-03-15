import java.util.*;
public class TeachingAssistant extends Person implements KPIEvaluator {
    public String employeeID;
    private int numberOfCourses;

    public TeachingAssistant(String name, int age, String gender, String employeeID, int numberOfCourses) {
        super(name, age, gender);
        this.employeeID = employeeID;
        this.numberOfCourses = numberOfCourses;
    }

    @Override
    public String getRole() {
        return "Teaching Assistant";
    }

    @Override
    public double calculateKPI() {
        return numberOfCourses * 5.0;
    }
}

