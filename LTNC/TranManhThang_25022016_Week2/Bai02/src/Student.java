public class Student {
    private int id;
    private String name;
    private String email;
    private float gpa;

    public Student() {}

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, String email, float gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        if (gpa < 0 || gpa > 4) this.gpa = 0;
        else this.gpa = gpa;
    }

    public Student(Student p_student) {
        this.id = p_student.id;
        this.name = p_student.name;
        this.email = p_student.email;  
        this.gpa = p_student.gpa;
    }

    public void setEmail(String p_email) {
        this.email = p_email;
    }

    public void setGpa(float p_gpa) {
        if (p_gpa < 0 || p_gpa > 4.0) return;
        this.gpa = p_gpa;
    }

    public void print() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("email: " + email);
        System.out.println("Gpa: " + gpa);
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setEmail("henryeatcat@gmail.com");
        Student student2 = new Student(10, "Cat");
        student2.setGpa(-1);
        Student student3 = new Student(student2);
        student1.print();
        student2.print();
        student3.print();
    }
}
