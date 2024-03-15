import java.util.*;
public abstract class Person {
    public String name;
    public int age;
    public String gender;
    protected String bank_account;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public abstract String getRole();
}
