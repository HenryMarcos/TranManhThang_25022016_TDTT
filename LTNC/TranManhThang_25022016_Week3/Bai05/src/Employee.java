public class Employee {
    protected String name;
    private String birthday;
    private String id;

    public Employee(String name, String birthday, String id) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
    }

    public Employee(String name) {
        this(name, null, null);
    }

    public double calculateSalary() {
        return 0;
    }
}
