import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int productAmount = sc.nextInt();

        WareHouse<Food> foodWarehouse = new WareHouse<>();
        WareHouse<Electronic> electronicWarehouse = new WareHouse<>();

        for (int i = 0; i < productAmount; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            switch (type) {
                case "E":
                    int warrantyMonths = sc.nextInt();
                    Electronic el = new Electronic(id, name, warrantyMonths);
                    electronicWarehouse.importProduct(el);
                    break;
                case "F":
                    String expiryDate = sc.next();
                    Food fd = new Food(id, name, expiryDate);
                    foodWarehouse.importProduct(fd);
                    break;
                default:
                    break;
            }
            sc.nextLine();
        }

        System.out.println("Kho Thực phẩm:");
        foodWarehouse.checkInventory();

        System.out.println();

        System.out.println("Kho Điện tử:");
        electronicWarehouse.checkInventory();

        sc.close();
    }
}
