public class PrototypeMain {
    public static void main(String[] args) {
        // 1. Tạo template gốc
        List<String> defaultSections = Arrays.asList("Mở đầu", "Nội dung chính", "Kết luận");
        ReportTemplate originalTemplate = new ReportTemplate("Báo Cáo Mẫu", "Trang 1/1", defaultSections);

        // 2. Sinh ra 2 bản sao từ template gốc
        ReportTemplate copy1 = originalTemplate.clone();
        ReportTemplate copy2 = originalTemplate.clone();

        // 3. Chỉnh sửa tiêu đề mỗi bản sao khác nhau
        copy1.setTitle("Báo Cáo Tài Chính Tháng 10");
        copy2.setTitle("Báo Cáo Nhân Sự Quý 3");

        // 4. In ra 3 báo cáo để kiểm tra template gốc không bị thay đổi
        System.out.println("--- KẾT QUẢ ---");
        System.out.print("Bản gốc: ");
        originalTemplate.printReport();
        
        System.out.print("Bản sao 1: ");
        copy1.printReport();
        
        System.out.print("Bản sao 2: ");
        copy2.printReport();
    }
}