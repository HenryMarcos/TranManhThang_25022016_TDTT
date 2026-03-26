import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return "PartTimeStaff " + getName() + " - Payment: " + df.format(getPaymentAmount());
    }
}
