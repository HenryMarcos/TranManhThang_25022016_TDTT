class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String msg) {
        super.send(msg); // Thực hiện chức năng của lớp bị bọc trước
        System.out.println("Gửi SMS: " + msg); // Thêm tính năng của riêng nó
    }
}