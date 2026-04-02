import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("-> Khách hàng [" + customer.getName() + "] vừa gửi yêu cầu và vào hàng đợi.");
    }

    public Customer processCustomer() {
        Customer c = queue.poll();

        if (c == null) {
            System.out.println("Không còn khách đợi");
            return null;
        }
        System.out.println("-> Khách hàng [" + c.getName() + "] vừa gửi yêu cầu và vào hàng đợi.");
        return c;
    }
}
