import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static int secondLargest(int[] arr) {
        if (arr.length < 2) return -1;
        int largest = arr[0];
        int secLargest = arr[1];
        if (largest < secLargest) {
            int c = largest;
            largest = secLargest;
            secLargest = c;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest) {
                if (secLargest < arr[i]) secLargest = arr[i];
            }
        }
        if (secLargest != largest) return secLargest;
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr_list = {{1, 2, 3, 4, 5}, {5, 5, 5, 5, 5}, {1}, {7, 8, 9, 9}};
        for (int i = 0; i < arr_list.length; i++) {
            System.out.println("Array: " + Arrays.toString(arr_list[i]));
            System.out.printf("Ans: %d\n", secondLargest(arr_list[i]));
        }        
    }
}
