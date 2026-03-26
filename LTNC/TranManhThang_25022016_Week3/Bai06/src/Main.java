import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Check if there is any number first
        if (!sc.hasNextInt()) return;
        int productNumber = sc.nextInt();

        sc.nextLine();

        double total = 0;

        Product[] order = new Product[productNumber];

        for (int i = 0; i < productNumber; i++) {
            String productType = sc.next();

            sc.findInLine("\"([^\"]*)\"");
            MatchResult result = sc.match();
            String productName = result.group(1);
            double basePrice = sc.nextDouble();

            switch (productType) {
                case "E":
                    double warrantyFees = sc.nextDouble();
                    order[i] = new Electronics(productType, productName, basePrice, warrantyFees);
                    break;
                case "F":
                    String expirationDate = sc.next();
                    order[i] = new Food(productType, productName, basePrice, expirationDate);
                    break;
            }

            total += order[i].getFinalPrice();

            sc.nextLine();
        }

        for (int i = 0; i < productNumber; i++) {
            System.out.println(order[i]);
        }
        DecimalFormat df = new DecimalFormat("#0.0");
        System.out.println("Total: " + df.format(total));
    }
}
