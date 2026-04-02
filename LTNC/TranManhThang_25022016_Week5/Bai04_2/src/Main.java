import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "students.dat";

        // ==========================================
        // PHẦN 1: NHẬP VÀ GHI DANH SÁCH SINH VIÊN
        // ==========================================
        System.out.println("--- NHẬP THÔNG TIN SINH VIÊN ---");
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // 2. Nhập danh sách cho tới khi gặp "END"
            while (true) {
                System.out.print("Nhập ID (hoặc gõ 'END' để kết thúc): ");
                String id = scanner.nextLine();
                
                if (id.equalsIgnoreCase("END")) {
                    break; // Kết thúc nhập
                }

                System.out.print("Nhập họ tên: ");
                String name = scanner.nextLine();

                System.out.print("Nhập GPA: ");
                // Dùng Double.parseDouble để tránh lỗi trôi lệnh khi dùng nextDouble() kết hợp nextLine()
                double gpa = Double.parseDouble(scanner.nextLine()); 

                // Khởi tạo đối tượng và ghi vào tệp
                Student student = new Student(id, name, gpa);
                oos.writeObject(student); // 3. Ghi ra tệp bằng ObjectOutputStream
                System.out.println("-> Đã thêm sinh viên!\n");
            }
            System.out.println("=> GHI FILE THÀNH CÔNG.\n");

        } catch (IOException e) {
            System.err.println("Lỗi I/O khi ghi tệp: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Định dạng điểm GPA không hợp lệ.");
        }


        // ==========================================
        // PHẦN 2: ĐỌC VÀ IN DANH SÁCH TỪ TỆP
        // ==========================================
        System.out.println("--- DANH SÁCH SINH VIÊN ĐỌC TỪ TỆP ---");
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // Đọc liên tục cho đến khi hết tệp (văng ra EOFException)
            while (true) {
                // 4. Đọc lại từ tệp bằng ObjectInputStream
                Student s = (Student) ois.readObject(); 
                System.out.println(s.toString());
            }

        // 5. Bắt đầy đủ các ngoại lệ theo yêu cầu
        } catch (EOFException e) {
            // Đây là tín hiệu bình thường khi đọc hết file ghi đối tượng tuần tự
            System.out.println("\n-> Đã đọc đến cuối tệp (EOF). Kết thúc!");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy định nghĩa lớp Student: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy tệp '" + fileName + "'.");
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi đọc tệp: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
