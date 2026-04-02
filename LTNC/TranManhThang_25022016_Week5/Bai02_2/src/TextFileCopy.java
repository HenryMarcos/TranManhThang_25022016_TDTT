import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn tệp nguồn và đích từ bàn phím
        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String destPath = scanner.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            // Dùng FileReader + BufferedReader và FileWriter + PrintWriter
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            // Đọc và ghi từng dòng
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++; // Tăng biến đếm dòng
            }

            // In số dòng đã sao chép nếu thành công
            System.out.println("Sao chép thành công!");
            System.out.println("Số dòng đã sao chép: " + lineCount);

        } catch (FileNotFoundException e) {
            // Xử lý FileNotFoundException
            // Dựa vào biến reader để biết lỗi xảy ra ở tệp nguồn hay tệp đích
            if (reader == null) {
                System.err.println("Source file not found.");
            } else {
                System.err.println("Cannot create destination file.");
            }
        } catch (IOException e) {
            // Xử lý IOException chung
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng tệp trong finally
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi đóng tệp: " + e.getMessage());
            }
            scanner.close();
        }
    }
}