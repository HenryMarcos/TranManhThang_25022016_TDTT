abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapper; // Đối tượng bị bọc

    public NotifierDecorator(Notifier wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void send(String msg) {
        // Chuyển tiếp lời gọi cho đối tượng bị bọc
        wrapper.send(msg);
    }
}