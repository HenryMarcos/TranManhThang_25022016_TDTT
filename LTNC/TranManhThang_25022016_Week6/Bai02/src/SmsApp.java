class SmsApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new SmsNotification(); // Quyết định tạo SmsNotification
    }
}