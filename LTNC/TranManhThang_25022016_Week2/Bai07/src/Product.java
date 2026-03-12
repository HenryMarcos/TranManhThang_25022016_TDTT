public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Product otherProduct) {
        this(otherProduct.id, otherProduct.name, otherProduct.price);
    }

    @Override 
    public String toString() {
        return "[Product's Id: " + id + ", Product's name: " + name + ", Product's price: " + price + "]"; 
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

