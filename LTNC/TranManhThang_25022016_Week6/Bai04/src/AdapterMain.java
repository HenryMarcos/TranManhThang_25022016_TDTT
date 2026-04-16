import java.util.Arrays;

public class AdapterMain {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));

        // Khởi tạo thư viện cũ và bọc nó trong Adapter
        LegacySorter oldLibrary = new LegacySorter();
        Sorter sorter = new SorterAdapter(oldLibrary);

        // Gọi hàm sort() thông qua interface mới
        int[] sortedNumbers = sorter.sort(numbers);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(sortedNumbers));
    }
}