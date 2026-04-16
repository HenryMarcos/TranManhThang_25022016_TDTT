import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookStore {
    private Map<String, Integer> stock;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public BookStore(Map<String, Integer> stock) {
        this.stock = stock;
    }

    public BookStore() {
        this(new HashMap<>());
    }

    public void initBook(String title, int qty) {
        stock.put(title, qty);
        System.out.println("Đã khởi tạo: " + title + " - Số lượng: " + qty);
    }

    // writeLock cho addBook
    public void addBook(String title, int qty) {
        lock.writeLock().lock(); // Khóa ghi: Chặn tất cả luồng đọc và ghi khác
        try {
            System.out.println(Thread.currentThread().getName() + " ĐANG NHẬP " + qty + " cuốn " + title + "...");
            Thread.sleep(100); // Giả lập thời gian xử lý để dễ quan sát log
            
            stock.put(title, stock.getOrDefault(title, 0) + qty);
            System.out.println(Thread.currentThread().getName() + " ĐÃ NHẬP XONG. Tổng " + title + ": " + stock.get(title));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock(); // Luôn luôn unlock trong khối finally
        }
    }

    // writeLock cho borrow
    public void borrow(String title, int qty) {
        lock.writeLock().lock(); // Khóa ghi
        try {
            System.out.println(Thread.currentThread().getName() + " ĐANG MƯỢN " + qty + " cuốn " + title + "...");
            Thread.sleep(100); 
            
            int currentQty = stock.getOrDefault(title, 0);
            if (currentQty >= qty) {
                stock.put(title, currentQty - qty);
                System.out.println(Thread.currentThread().getName() + " ĐÃ MƯỢN THÀNH CÔNG. Còn lại " + title + ": " + stock.get(title));
            } else {
                System.out.println(Thread.currentThread().getName() + " MƯỢN THẤT BẠI (Không đủ sách).");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }

    // readLock cho getStock
    public Integer getStock(String title) {
        lock.readLock().lock(); // Khóa đọc: Cho phép nhiều luồng cùng đọc, nhưng chặn luồng ghi
        try {
            System.out.println(Thread.currentThread().getName() + " đang kiểm tra số lượng sách " + title + "...");
            Thread.sleep(50); 
            
            int qty = stock.getOrDefault(title, 0);
            System.out.println(Thread.currentThread().getName() + " thấy có " + qty + " cuốn " + title);
            return qty;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        } finally {
            lock.readLock().unlock();
        }
    }
}
