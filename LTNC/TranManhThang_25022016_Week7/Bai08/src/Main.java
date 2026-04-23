
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        ExecutorService pool1 = Executors.newFixedThreadPool(n);
        ExecutorService pool2 = Executors.newFixedThreadPool(n);

        List<CompletableFuture<Long>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();

            int[] array = new int[s];

            for (int j = 0; j < s; j++) {
                array[j] = sc.nextInt();
            }

            final int arrayId = i;

            TwoStageProcessing task = new TwoStageProcessing(arrayId, array);

            CompletableFuture<Long> future = CompletableFuture.supplyAsync(task, pool1)
                    .thenApplyAsync(primes -> {
                        // Logic Giai đoạn 2
                        long sum = 0;
                        boolean isEvenCount = (primes.size() % 2 == 0);

                        for (int p : primes) {
                            if (isEvenCount) {
                                sum += (long) p * p;
                            } else {
                                sum += (long) p * p * p;
                            }
                        }

                        // Hoàn thành Giai đoạn 2: in ra luôn
                        String operation = isEvenCount ? "squares" : "cubes";
                        System.out.println("Stage 2 - Array " + arrayId + ": sum of " + operation + " = " + sum);

                        return sum;
                    }, pool2);

            futures.add(future);
            sc.nextLine();
        }

        long totalSum = 0;

        // Chờ kết quả của tất cả các CompletableFuture và cộng dồn
        for (CompletableFuture<Long> future : futures) {
            totalSum += future.join();
        }

        System.out.println("Total = " + totalSum);

        // Nhớ đóng các ThreadPool để chương trình dừng hẳn
        pool1.shutdown();
        pool2.shutdown();
        sc.close();

    }
}
