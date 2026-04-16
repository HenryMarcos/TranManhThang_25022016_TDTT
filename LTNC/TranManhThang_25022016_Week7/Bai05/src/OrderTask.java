import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderTask implements Callable<Boolean> {
    private String id;
    private long processMs;
    private List<String> logs;
    private AtomicInteger successCount;

    public OrderTask(String id, long processMs, List<String> logs, AtomicInteger successCount) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
        this.successCount = successCount;
    }

    @Override
    public Boolean call() {
        System.out.println("Start " + id);

        try {
            Thread.sleep(processMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Đơn hàng " + id + " bị gián đoạn.");
        }

        boolean isSuccess = processMs <= 1500;
        String logMessage = (isSuccess? "DONE ": "FAIL ") + id;

        synchronized (logs) {
            logs.add(logMessage);
        }

        if (isSuccess) {
            successCount.incrementAndGet();
        }

        return isSuccess;
    }
}
