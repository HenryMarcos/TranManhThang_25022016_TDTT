public class Manager extends Employee {
    private String department;

    public Manager() {
        System.out.println("3. Manager is created");
    }

    public static void main(String[] args) {
        Manager m = new Manager();
    }
}
