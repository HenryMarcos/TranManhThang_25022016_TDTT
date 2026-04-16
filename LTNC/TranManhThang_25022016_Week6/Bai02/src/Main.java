public class Main {
    public static void main(String[] args) {
        // Chọn ứng dụng gửi Email
        System.out.println("--- Khởi chạy Email App ---");
        NotificationApp emailApp = new EmailApp();
        emailApp.notifyUser("Chào bạn, bạn có một email mới!");

        // Chọn ứng dụng gửi SMS
        System.out.println("\n--- Khởi chạy SMS App ---");
        NotificationApp smsApp = new SmsApp();
        smsApp.notifyUser("Mã OTP của bạn là 123456.");
    }
}