import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 1. Tạo ngoại lệ tự định nghĩa (Custom Exception)
class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = null;
        Map<String, String> configMap = new HashMap<>();

        try {
            // 2. Đọc file theo từng dòng bằng FileReader + BufferedReader
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Bỏ qua các dòng trống

                // Tách theo dấu '=' thành tối đa 2 phần (đề phòng value cũng có chứa dấu '=')
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configMap.put(key, value); // Lưu vào Map
                }
            }

            // 3. Kiểm tra dữ liệu (Validation)
            if (!configMap.containsKey("username")) {
                throw new InvalidConfigException("Thiếu tham số 'username'.");
            }
            if (!configMap.containsKey("timeout")) {
                throw new InvalidConfigException("Thiếu tham số 'timeout'.");
            }

            // Ép kiểu timeout (sẽ ném NumberFormatException nếu không phải số)
            int timeout = Integer.parseInt(configMap.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("Giá trị 'timeout' phải > 0.");
            }

            // Kiểm tra maxConnections nếu tồn tại
            if (configMap.containsKey("maxConnections")) {
                int maxConn = Integer.parseInt(configMap.get("maxConnections"));
                if (maxConn < 1) {
                    throw new InvalidConfigException("Giá trị 'maxConnections' phải >= 1.");
                }
            }

            // Nếu không có lỗi nào xảy ra -> Cấu hình hợp lệ
            System.out.println("\n--- Toàn bộ cấu hình ---");
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            // 4. Xử lý ngoại lệ không tìm thấy file
            System.out.println("Config file not found.");
        } catch (IOException e) {
            // Xử lý lỗi I/O và in stack trace
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Xử lý lỗi ép kiểu dữ liệu
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            // Bắt và in ngoại lệ tự định nghĩa
            System.out.println("Invalid config: " + e.getMessage());
        } finally {
            // 5. Đảm bảo đóng file trong khối finally
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi đóng file: " + e.getMessage());
            }
            
            // 6. Luôn in dòng này dù có lỗi hay không
            System.out.println("Program finished.");
            scanner.close();
        }
    }
}