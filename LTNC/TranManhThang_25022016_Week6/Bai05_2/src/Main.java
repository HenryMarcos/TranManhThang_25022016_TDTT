public class Main {
    public static void main(String[] args) {
        // Cố tình gọi getInstance ở nhiều nơi khác nhau
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Kiểm tra xem hai biến logger có trỏ về cùng một địa chỉ bộ nhớ không
        boolean isEqual = (logger1 == logger2);
        System.out.println("Logger instances equal: " + isEqual);
        System.out.println(); // Dòng trống cho dễ nhìn

        // Thực hiện ghi log qua các biến khác nhau (nhưng thực chất gọi vào cùng 1 object)
        logger1.logInfo("Application started");
        logger2.logInfo("Loading modules...");
        logger1.logError("Failed to connect to Database");
        
        // Lỗi biên dịch nếu bạn cố tình mở comment dòng dưới:
        // Logger wrongLogger = new Logger(); // Báo lỗi "Logger() has private access"
    }
}
