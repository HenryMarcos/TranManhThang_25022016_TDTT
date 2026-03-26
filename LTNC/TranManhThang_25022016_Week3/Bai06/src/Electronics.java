import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class Electronics extends Product {
    private static double taxRate = 0.1;
    private double warrantyFees;

    public Electronics(String id, String name, double basePrice, double warrantyFees) {
        super(id, name, basePrice);
        this.warrantyFees = warrantyFees;
    }

    @Override
    public double getFinalPrice() {
        return basePrice * (1 + taxRate) + warrantyFees;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return name + " - Electronics - " + df.format(getFinalPrice());
    }
}
