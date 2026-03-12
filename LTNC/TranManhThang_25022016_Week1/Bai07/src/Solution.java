import java.util.Scanner;

public class Solution {
    public static int reverse(int n) {
        int ans = 0;
        while (n > 0) {
            ans *= 10;
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap 1 so: ");
        long a = scanner.nextLong();
        int ans;
        if (a > Integer.MAX_VALUE) ans = 0;
        else ans = reverse((int)a);
        System.out.printf("Ans: %d", ans);
        
    }
}
