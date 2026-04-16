public class Main {
    public static void main(String[] args) {
        // Giả lập tham số cấu hình nhận vào (có thể từ args[0] hoặc file config)
        String osConfig = "win"; // Hãy thử đổi thành "mac" để xem sự khác biệt
        
        UIFactory factory;

        // Dựa vào cấu hình để khởi tạo đúng loại Factory
        if (osConfig.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else if (osConfig.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("Hệ điều hành không được hỗ trợ!");
        }

        // Tạo và hiển thị các thành phần UI
        // Ở bước này, code client không cần biết lớp cụ thể (WindowsButton hay MacButton)
        // Nó chỉ làm việc qua interface Button và Checkbox.
        System.out.println("--- Khởi tạo giao diện cho: " + osConfig.toUpperCase() + " ---");
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}