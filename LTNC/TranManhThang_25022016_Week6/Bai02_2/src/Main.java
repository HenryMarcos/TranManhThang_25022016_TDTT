public class Main {
    public static void main(String[] args) {
        System.out.println("--- Tạo Notifier: Chỉ Email ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Khuyến mãi 50% hôm nay!");

        System.out.println("\n--- Tạo Notifier: Email + Facebook + SMS ---");
        // Bọc (Wrap) các Notifier lại với nhau
        Notifier multiChannelNotifier = new SMSNotifier(
                                            new FacebookNotifier(
                                                new EmailNotifier()
                                            )
                                        );
        multiChannelNotifier.send("Cảnh báo: Tài khoản của bạn vừa đăng nhập ở thiết bị lạ!");
    }
}
