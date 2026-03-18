import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return this.workingHours * this.hourlyRate;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return this.name + " - Part-time - " + df.format(calculateSalary());
    }
}
