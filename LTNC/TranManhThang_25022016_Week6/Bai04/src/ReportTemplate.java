import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = new ArrayList<>(sections);
    }

    // Cài đặt sao chép (clone)
    @Override
    public ReportTemplate clone() {
        try {
            // Shallow copy (chỉ copy các kiểu dữ liệu nguyên thủy và chuỗi)
            ReportTemplate cloned = (ReportTemplate) super.clone();
            
            // Deep copy cho List (RẤT QUAN TRỌNG: để bản sao và bản gốc không trỏ chung 1 vùng nhớ List)
            cloned.sections = new ArrayList<>(this.sections);
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Getters / Setters
    public void setTitle(String title) { this.title = title; }
    public String getTitle() { return title; }

    // Phương thức in thông tin báo cáo
    public void printReport() {
        System.out.println("Báo cáo: [Title: '" + title + "', Footer: '" + footer + "', Sections: " + sections + "]");
    }
}