import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ==========================================
        // 1. CHƯƠNG TRÌNH GHI DỮ LIỆU
        // ==========================================
        System.out.println("--- PHẦN 1: GHI DỮ LIỆU VÀO TỆP NHỊ PHÂN ---");
        // System.out.print("Nhập tên tệp để ghi (VD: numbers.bin): ");
        String writeFileName = "numbers.bin";

        System.out.print("Nhập số lượng số nguyên (n): ");
        int n = scanner.nextInt();

        // Sử dụng try-with-resources để tự động đóng luồng (close) sau khi xong
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(writeFileName))) {
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                int num = scanner.nextInt();
                dos.writeInt(num); // Ghi số nguyên vào tệp nhị phân
            }
            System.out.println("-> Đã ghi thành công " + n + " số vào tệp '" + writeFileName + "'.\n");
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi ghi tệp: " + e.getMessage());
        }

        // Xóa bộ đệm (phím Enter bị thừa) sau khi nhập số để chuẩn bị nhập chuỗi tiếp theo
        scanner.nextLine(); 

        // ==========================================
        // 2. CHƯƠNG TRÌNH ĐỌC DỮ LIỆU
        // ==========================================
        System.out.println("--- PHẦN 2: ĐỌC DỮ LIỆU TỪ TỆP NHỊ PHÂN ---");
        // System.out.print("Nhập tên tệp để đọc lại: ");
        String readFileName = "numbers.bin";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(readFileName))) {
            System.out.println("Các số đọc được từ tệp:");
            
            // Vòng lặp vô hạn, sẽ bị phá vỡ khi đọc đến cuối tệp (quăng ra EOFException)
            while (true) {
                int number = dis.readInt();
                System.out.print(number + " ");
            }
            
        } catch (EOFException e) {
            // Yêu cầu bắt buộc của bài toán: Dừng đọc bằng cách bắt EOFException
            System.out.println("\n\n-> Đã đọc đến cuối tệp (Bắt được EOFException). Quá trình đọc hoàn tất.");
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy tệp '" + readFileName + "'. Hãy chắc chắn bạn đã nhập đúng tên.");
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi đọc tệp: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}