import java.util.*;
public abstract class Staff {
    protected String employeeID;
    public String cardID;
    public String name;
    public String skill;

    public Staff(String employeeID, String cardID, String name, String skill) {
        this.employeeID = employeeID;
        this.cardID = cardID;
        this.name = name;
        this.skill = skill;
    }

    public abstract String getLevel();
}
