
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new StandardOrder(2.0, 10.0));
        orders.add(new ExpressOrder(2.0, 10.0));
        orders.add(new FragileOrder(1.5, 5.0));
        orders.add(new BulkyOrder(10.0, 20.0)); // Loại mới thêm vào

        System.out.println("DANH SÁCH PHÍ GIAO HÀNG:");
        for (Order o : orders) {
            System.out.printf("%-15s | Phí: %,.0f VNĐ%n", o.getLabel(), o.getDeliveryFee());
        }
    }
}