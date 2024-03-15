import java.util.*;
public class Fresher extends Staff implements KPI {
    private double quality;
    boolean deadline;

    public Fresher(String employeeID, String cardID, String name, String skill, double quality, boolean deadline) {
        super(employeeID, cardID, name, skill);
        this.quality = quality;
        this.deadline = deadline;
    }

    @Override
    public String getLevel() {
        return "Fresher";
    }

    @Override
    public double kpi() {
        return quality * 60 + (deadline ? 20 : 0);
    }
}

