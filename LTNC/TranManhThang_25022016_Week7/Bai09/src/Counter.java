
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;

    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        try {
            if (lock.tryLock(50, TimeUnit.MILLISECONDS)) {
                try {
                    value++;
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
            } else {
                // In thông báo nếu không lấy được lock sau 50ms
                System.out.println(Thread.currentThread().getName() + " không lấy được lock, bỏ qua lần tăng này!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " bị ngắt quãng trong lúc chờ lock.");
        }
    }

    public int getValue() {
        return value;
    }
}
