import java.time.LocalDate;

public class Food extends Product {
    private LocalDate expiryDate;
    
    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = LocalDate.parse(expiryDate);
    }

    @Override
    public String toString() {
        return name + " - " + expiryDate;
    }
}
