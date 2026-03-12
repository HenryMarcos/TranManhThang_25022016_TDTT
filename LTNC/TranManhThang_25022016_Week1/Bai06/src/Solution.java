import java.util.Scanner;

public class Solution {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap 1 so: ");
        int a = scanner.nextInt();
        System.out.printf("Ans: %b", isPrime(a));
    }
}
