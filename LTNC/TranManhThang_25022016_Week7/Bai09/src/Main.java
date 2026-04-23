public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                }
            }, "Thread-" + (i + 1));

            threads[i].start();
        }

        for (int i = 0; i < 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Luồng chính bị ngắt quãng khi đang chờ.");
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Giá trị cuối cùng của counter: " + counter.getValue());
        System.out.println("Giá trị kỳ vọng: 40000 (Nếu không có luồng nào bị quá hạn/timeout khi tryLock)");
    }
}
