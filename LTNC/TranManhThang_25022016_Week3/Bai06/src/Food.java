import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Food extends Product {
    private LocalDate expirationDate;
    
    public Food(String id, String name, double basePrice, String expirationDate) {
        super(id, name, basePrice);
        this.expirationDate = LocalDate.parse(expirationDate);
    }

    @Override
    public double getFinalPrice() {
        LocalDate nowaday = LocalDate.now();
        
        if (expirationDate.isEqual(nowaday) || 
            expirationDate.isBefore(nowaday) || 
            ChronoUnit.DAYS.between(expirationDate, nowaday) < 7) 
        {
            return basePrice * 0.8;
        }
        return basePrice;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.0");
        return name + " - Food - " + df.format(getFinalPrice());
    }

}
