import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class Main {
    public static int calSum(int[] array, int start, int end) {
        int ans = 0;
        for (int i = start; i <= end; i++) {
            ans += array[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int k = 4;

        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> futures = new ArrayList<>();

        int chunkSize = (int) Math.ceil((double) n / k);

        for (int i = 0; i < k; i++) {
            int start = i * chunkSize;

            if (start >= n) break;

            int end = Math.min(start + chunkSize, n);

            Callable<Integer> task = new SegmentSum(array, start, end);

            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        int totalSum = 0;

        try {
            for (Future<Integer> future: futures) {
                totalSum += future.get();
            }

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Đã xảy ra lỗi trong quá trình tính toán song song.");
            e.printStackTrace();
        }

        System.out.println("Tổng của mảng là: " + totalSum);
        
        // Đóng ExecutorService để giải phóng tài nguyên hệ thống
        executor.shutdown();
        scanner.close();
    }
}
