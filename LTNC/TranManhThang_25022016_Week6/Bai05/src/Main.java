public class Main {
    public static void main(String[] args) {
        System.out.println("--- KIỂM TRA 1: SINGLETON (Logger) ---");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Hệ thống khởi động.");
        System.out.println("logger1 và logger2 có cùng một đối tượng không? " + (logger1 == logger2));

        System.out.println("\n--- KIỂM TRA 2: FACTORY METHOD (Export) ---");
        // Khởi tạo thông qua Factory, không dùng 'new PdfExport()' trực tiếp ở đây
        ExportFactory pdfFactory = new PdfFactory();
        Export myPdf = pdfFactory.createExport();
        myPdf.exportData();

        ExportFactory excelFactory = new ExcelFactory();
        Export myExcel = excelFactory.createExport();
        myExcel.exportData();

        System.out.println("\n--- KIỂM TRA 3: ADAPTER (Player) ---");
        OldPlayer oldSystemPlayer = new OldPlayer();
        // Bọc lớp cũ vào Adapter để dùng được theo chuẩn mới
        Player player = new PlayerAdapter(oldSystemPlayer);
        player.play("video_huong_dan.mp4");

        System.out.println("\n--- KIỂM TRA 4: PROTOTYPE (Config) ---");
        SystemConfig originalConfig = new SystemConfig("Dark Mode", "Tiếng Việt");
        // Sinh ra bản sao
        SystemConfig clonedConfig = originalConfig.clone();
        
        // Chỉnh sửa bản sao
        clonedConfig.setTheme("Light Mode");
        clonedConfig.setLanguage("English");

        // Kiểm tra xem bản gốc có bị thay đổi không
        originalConfig.displayConfig("Bản gốc");
        clonedConfig.displayConfig("Bản sao");
    }
}