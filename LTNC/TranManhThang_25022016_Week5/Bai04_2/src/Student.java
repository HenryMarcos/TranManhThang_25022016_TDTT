import java.io.Serializable;

class Student implements Serializable {
    // serialVersionUID giúp đảm bảo tính tương thích khi đọc/ghi đối tượng
    private static final long serialVersionUID = 1L; 
    
    String id;
    String name;
    double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Mã SV: " + id + " | Họ tên: " + name + " | GPA: " + gpa;
    }
}