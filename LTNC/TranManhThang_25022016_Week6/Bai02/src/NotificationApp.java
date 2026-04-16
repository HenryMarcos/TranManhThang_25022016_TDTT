abstract class NotificationApp {
    
    // Abstract factory method: Để các lớp con tự quyết định việc khởi tạo
    protected abstract Notification createNotification();

    // Phương thức notifyUser không tạo trực tiếp đối tượng bằng từ khóa 'new'
    // mà gọi thông qua factory method
    public void notifyUser(String msg) {
        // Lấy ra đối tượng Notification tương ứng do lớp con quyết định
        Notification notification = createNotification();
        // Thực hiện hành động gửi
        notification.send(msg);
    }
}