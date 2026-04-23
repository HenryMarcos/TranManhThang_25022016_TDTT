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

            Callable<Integer> task = new SecondLargestTask(array);

            Future<Integer> future = executorService.submit(task);
            futures.add(future);

            sc.nextLine();
        }

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            try {
                Integer secondLargest = futures.get(i).get();
                System.out.print("Array " + i + ": ");
                if (secondLargest == null) {
                    System.out.println("Not found");
                } else {
                    System.out.println("second largest: " + secondLargest);
                    totalSum += secondLargest;
                }

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum = " + totalSum);
        executorService.shutdown();
    }
}
