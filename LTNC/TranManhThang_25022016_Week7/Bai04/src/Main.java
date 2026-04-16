public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        // Khởi tạo một vài sách có sẵn
        System.out.println("--- KHỞI TẠO ---");
        store.initBook("Java Core", 10);
        store.initBook("Clean Code", 5);
        System.out.println("----------------\n");

        // Tạo 3 luồng đọc (in số lượng sách)
        Runnable readTask = () -> {
            store.getStock("Java Core");
        };
        Thread reader1 = new Thread(readTask, "Reader-1");
        Thread reader2 = new Thread(readTask, "Reader-2");
        Thread reader3 = new Thread(readTask, "Reader-3");

        // Tạo 2 luồng ghi (mượn/nhập sách)
        Thread writer1 = new Thread(() -> {
            store.borrow("Java Core", 3);
        }, "Writer-1 (Borrow)");

        Thread writer2 = new Thread(() -> {
            store.addBook("Java Core", 5);
        }, "Writer-2 (Add)");

        // Chạy các luồng đồng thời
        reader1.start();
        reader2.start();
        writer1.start(); // Luồng ghi xen ngang
        reader3.start();
        writer2.start(); // Luồng ghi tiếp theo
    }
}
