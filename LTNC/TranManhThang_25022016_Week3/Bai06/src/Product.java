public class Product {
    protected String id;
    protected String name;
    protected double basePrice;

    public Product(String id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return basePrice;
    }
}
