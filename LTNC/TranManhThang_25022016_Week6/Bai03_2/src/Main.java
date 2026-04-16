public class Main {
    public static void main(String[] args) {
        Report myReport = new Report("Báo Cáo Doanh Thu", "Tháng này tăng trưởng 20%");

        // 1. Xuất định dạng JSON
        System.out.println("--- XUẤT JSON ---");
        ReportService service1 = new ReportService(new JsonFormatter());
        System.out.println(service1.export(myReport));

        // 2. Xuất định dạng XML
        System.out.println("\n--- XUẤT XML ---");
        ReportService service2 = new ReportService(new XmlFormatter());
        System.out.println(service2.export(myReport));
        
        // => MỞ RỘNG: Nếu ngày mai sếp yêu cầu xuất HTML, ta chỉ việc tạo class HtmlFormatter 
        // implements ReportFormatter. Lớp ReportService giữ nguyên, không cần sửa đổi 1 dòng code nào!
    }
}