class EmailApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new EmailNotification(); // Quyết định tạo EmailNotification
    }
}