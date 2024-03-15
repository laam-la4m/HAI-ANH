import java.util.*;
public final class Leader extends Junior_Senior {
    public static int countLeader = 0;
    private double project;

    public Leader(String employeeID, String cardID, String name, String skill, double quality, boolean deadline, int exp_year, double project) {
        super(employeeID, cardID, name, skill, quality, deadline, exp_year);
        this.project = project;
        countLeader++;
    }

    @Override
    public String getLevel() {
        return "Leader";
    }

    @Override
    public double kpi() {
        return super.kpi() + (deadline ? 20 : -30) + project * 3; // Adjusted for Leader specifics
    }
}
