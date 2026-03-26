public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {}

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        if (gpa < 0 || gpa > 10) this.gpa = 0;
        else this.gpa = gpa;
    }

    public Student(Student p_student) {
        this.id = p_student.id;
        this.name = p_student.name;
        this.email = p_student.email;  
        this.gpa = p_student.gpa;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String p_email) {
        this.email = p_email;
    }

    public void setGpa(double p_gpa) {
        if (p_gpa < 0 || p_gpa > 10.0) return;
        this.gpa = p_gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void print() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("email: " + email);
        System.out.println("Gpa: " + gpa);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}
