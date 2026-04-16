class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Đang gửi SMS với nội dung: " + msg);
    }
}