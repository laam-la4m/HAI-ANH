
import java.util.*;

public class Junior_Senior extends Fresher {

    private int exp_year;

    public Junior_Senior(String employeeID, String cardID, String name, String skill, double quality, boolean deadline, int exp_year) {
        super(employeeID, cardID, name, skill, quality, deadline);
        this.exp_year = exp_year;
    }

    @Override
    public String getLevel() {
        return "Junior/Senior";
    }

    @Override
    public double kpi() {
        return super.kpi() + (deadline ? 15 : -10) + exp_year * 2; // Adjusted to include exp_year in the KPI calculation
    }

    int getExpYear() {
        return exp_year;
    }
}
