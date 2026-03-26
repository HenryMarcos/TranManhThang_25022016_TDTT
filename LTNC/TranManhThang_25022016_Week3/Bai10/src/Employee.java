import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.1;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return name + " - Bonus: " + df.format(calculateBonus());
    }
}
