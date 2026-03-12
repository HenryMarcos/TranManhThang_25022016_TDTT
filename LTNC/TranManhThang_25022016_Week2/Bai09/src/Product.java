import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        return (this.price - this.discount) * (1 + taxRate);
    }

    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount > this.quantity) {
            System.err.println("Not enough items");
            return;
        }
        this.quantity -= amount;
        totalRevenue += amount * calculateFinalPrice();
        System.out.println("Succeed!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input data for product 1");
        Product p1 = new Product(scanner.nextLine(), scanner.nextDouble(), scanner.nextInt(), scanner.nextDouble());
        scanner.nextLine(); // consume newline
        System.out.println("Input data for product 2");
        Product p2 = new Product(scanner.nextLine(), scanner.nextDouble(), scanner.nextInt(), scanner.nextDouble());

        System.out.println("How much do you want to buy from product 1: ");
        int p1Amount = scanner.nextInt();
        p1.sell(p1Amount);
        System.out.println("How much do you want to buy from product 2: ");
        int p2Amount = scanner.nextInt();
        p2.sell(p2Amount);

        scanner.close();
        System.out.printf("Product 1's final price: %f\n", p1.calculateFinalPrice());
        System.out.printf("Product 2's final price: %f\n", p2.calculateFinalPrice());

        Product.updateTaxRate(.08);
        System.out.printf("Product 1's final price: %f\n", p1.calculateFinalPrice());
        System.out.printf("Product 2's final price: %f\n", p2.calculateFinalPrice());

        p1.updateDiscount(10);
        System.out.printf("Product 1's final price: %f\n", p1.calculateFinalPrice());
        System.out.printf("Product 2's final price: %f\n", p2.calculateFinalPrice());
    }
}
