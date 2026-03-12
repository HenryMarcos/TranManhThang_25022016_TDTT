import java.util.Scanner;

public class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap 2 so a va b:");
        int a = scanner.nextInt(), b = scanner.nextInt();
        System.out.printf("UCLN cua %d va %d: %d", a, b, gcd(a, b));
    }
}
