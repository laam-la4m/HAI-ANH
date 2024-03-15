
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class PersonManager {

    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        try {
            persons.add(person);
        } catch (Exception e) {
            System.out.println("Cannot add person: " + e.getMessage());
        }
    }

    public void displayPersons() {
        for (Person person : persons) {
            if (person instanceof Student) {
                System.out.println("Student: " + person.getName() + ", Age: " + person.getAge() + ", GPA: " + ((Student) person).getGpa());
            } else if (person instanceof Teacher) {
                System.out.println("Teacher: " + person.getName() + ", Age: " + person.getAge() + ", Salary: " + String.format("%,.2f", ((Teacher) person).getSalary()));
            } else if (person instanceof Staff) {
                System.out.println("Staff: " + person.getName() + ", Age: " + person.getAge() + ", Role: " + ((Staff) person).getRole());
            }
        }
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Person person : persons) {
            if (person instanceof Teacher) {
                totalSalary += ((Teacher) person).getSalary();
            }
        }
        return totalSalary;
    }
}
