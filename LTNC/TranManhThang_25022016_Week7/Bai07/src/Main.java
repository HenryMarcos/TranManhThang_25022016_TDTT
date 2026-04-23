
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        ExecutorService executorService = Executors.newFixedThreadPool(n);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();

            int[] array = new int[s];
            
            for (int j = 0; j < s; j++) {
                array[j] = sc.nextInt();
            }

            Callable<Integer> task = new CountPrimeTask(array);

            Future<Integer> future = executorService.submit(task);
            futures.add(future);
        }

        int maxPrimePos = -1;
        int maxPrimeCount = -1;

        for (int i = 0; i < n; i++) {
            try {
                int primeCount = futures.get(i).get();
                System.out.println("Array " + i + ": " + primeCount);
                if (primeCount > maxPrimeCount) {
                    maxPrimeCount = primeCount;
                    maxPrimePos = i;
                }
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        System.out.println("Most primes: Array " + maxPrimePos + " with " + maxPrimeCount + " primes");
        executorService.shutdown();
    }
}
