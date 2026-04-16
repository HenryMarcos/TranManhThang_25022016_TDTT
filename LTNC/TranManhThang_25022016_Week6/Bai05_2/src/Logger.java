class Logger {
    // 1. Thuộc tính private static chứa đối tượng duy nhất
    private static Logger instance;

    // 2. Constructor private để không ai có thể dùng new Logger()
    private Logger() {}

    // 3. Phương thức public static để lấy đối tượng (Lazy Init)
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) 
                    instance = new Logger(); // Chỉ tạo mới nếu nó chưa từng tồn tại
            }
        }
        return instance;
    }

    // 4. Các phương thức ghi log
    public void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}