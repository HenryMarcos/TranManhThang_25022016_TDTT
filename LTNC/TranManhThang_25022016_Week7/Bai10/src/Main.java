public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        
        thread.start();

        try {
            // Cho luồng chạy khoảng 1 giây
            Thread.sleep(1000);
            
            // Yêu cầu dừng luồng
            System.out.println("Stopping worker...");
            worker.stop();

            // Đợi luồng kết thúc hoàn toàn
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
