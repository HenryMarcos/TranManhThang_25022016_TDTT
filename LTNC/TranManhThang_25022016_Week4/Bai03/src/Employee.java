import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract public double calculatePay();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return name + " - Pay: " + df.format(calculatePay());
    }

    /*
    Không cần implement hàm work()
    */

}
