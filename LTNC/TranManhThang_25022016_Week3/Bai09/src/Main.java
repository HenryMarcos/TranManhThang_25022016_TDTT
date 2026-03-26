import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int amount = sc.nextInt();
        sc.nextLine();

        IPayable[] payableList = new IPayable[amount];

        for (int i = 0; i < amount; i++) {
            String paymentType = sc.next();

            switch (paymentType) {
                case "S":
                    String id = sc.next();
                    String name = sc.next();
                    int workingHours = sc.nextInt();
                    double hourlyRate = sc.nextDouble();
                    payableList[i] = new PartTimeStaff(id, name, workingHours, hourlyRate);
                    break;
                case "I":
                    String itemName = sc.next();
                    int itemQuantity = sc.nextInt();
                    double pricePerItem = sc.nextDouble();
                    payableList[i] = new Invoice(itemName, itemQuantity, pricePerItem);
                    break;
                default:
                    break;
            }
            sc.nextLine();
        }

        double total = 0;

        for (int i = 0; i < amount; i++) {
            total += payableList[i].getPaymentAmount();
            System.out.println(payableList[i]);
        }

        DecimalFormat df = new DecimalFormat("#0.0");

        System.out.println("Total Payment: " + df.format(total));
    } 
}
