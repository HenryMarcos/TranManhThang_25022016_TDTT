import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return "Invoice " + itemName + " - Payment: " + df.format(getPaymentAmount()); 
    }
}
