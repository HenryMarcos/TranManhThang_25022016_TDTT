public class Worker implements Runnable {
    // volatile đảm bảo mọi luồng đều nhìn thấy giá trị mới nhất của biến ngay khi nó thay đổi
    // Nếu không có volatile: Khi luồng main thay đổi running = false, 
    // luồng Worker có thể vẫn đang đọc giá trị cũ từ cache của nó và tiếp tục lặp vô tận.
    // Khi có volatile: mọi thay đổi thực hiện bởi một luồng sẽ ngay lập tức được nhìn thấy bởi các luồng khác
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
            try {
                // Nghỉ một chút để tránh làm tràn màn hình console
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
