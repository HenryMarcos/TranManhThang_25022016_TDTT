public class Solution {
    public static long fibonacci(long n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        long ar[] = new long[(int)n + 1];

        ar[0] = 0;
        ar[1] = 1;

        int i = 0;

        if (i < n) i++;

        while(i < n) {
            i++;
            if (ar[i - 1] > Long.MAX_VALUE - ar[i - 2]) return Long.MAX_VALUE;
            ar[i] = ar[i - 1] + ar[i - 2];
        }
        return ar[(int)n];
        
    }
    public static void main(String[] args) {
        for (int i = -1; i <= 100; i++) {
            System.out.println("So fibonacci thu " + i + ": " + fibonacci(i));
        }
    }
}
