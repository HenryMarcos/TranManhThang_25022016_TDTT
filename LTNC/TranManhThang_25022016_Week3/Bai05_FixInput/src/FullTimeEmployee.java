import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary + (this.bonus - this.penalty);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return this.name + " - Full-time - " + df.format(calculateSalary());
    }
}
