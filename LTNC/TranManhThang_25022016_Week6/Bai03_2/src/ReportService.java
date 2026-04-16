class ReportService {
    private ReportFormatter formatter;

    // Nhận formatter thông qua Dependency Injection (Constructor)
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    // Nếu muốn đổi định dạng lúc runtime, có thể cung cấp thêm Setter
    public void setFormatter(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        // Giao phó việc định dạng cho Formatter
        return formatter.format(data);
    }
}