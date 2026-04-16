import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập m đơn hàng
        System.out.print("Nhập số lượng đơn hàng m: ");
        int m = scanner.nextInt();

        List<String> ids = new ArrayList<>();
        List<Long> times = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            System.out.print("Nhập ID đơn hàng thứ " + (i + 1) + ": ");
            ids.add(scanner.next());
            System.out.print("Nhập thời gian xử lý (ms) cho " + ids.get(i) + ": ");
            times.add(scanner.nextLong());
        }

        // Khởi tạo danh sách log chung và bộ đếm AtomicInteger
        List<String> sharedLogs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);

        // 2. Dùng ExecutorService (fixed thread pool) để xử lý song song
        // Tạo pool với số luồng cố định (ví dụ: 3 luồng)
        int poolSize = 3; 
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        List<Future<Boolean>> futures = new ArrayList<>();

        System.out.println("\n--- BẮT ĐẦU XỬ LÝ ---");
        for (int i = 0; i < m; i++) {
            Callable<Boolean> task = new OrderTask(ids.get(i), times.get(i), sharedLogs, successCount);
            // Submit tác vụ vào Thread Pool
            futures.add(executor.submit(task));
        }

        // 6. Đợi Future.get() xong hết
        for (Future<Boolean> future : futures) {
            try {
                // get() sẽ block luồng main cho đến khi Callable hiện tại hoàn thành
                future.get(); 
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // In kết quả
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Success = " + successCount.get());
        
        System.out.println("Danh sách log theo thứ tự hoàn thành:");
        // Vì List được add ngay sau khi sleep xong, nên thứ tự trong list chính là thứ tự hoàn thành
        for (String log : sharedLogs) {
            System.out.println("- " + log);
        }

        // 7. Đóng ExecutorService đúng cách
        executor.shutdown();
        scanner.close();
    }
}
