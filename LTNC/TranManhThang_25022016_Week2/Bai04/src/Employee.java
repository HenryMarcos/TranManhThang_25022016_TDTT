public class Employee {
    private String name;
    private MyDate birthday;

    public Employee() {};
    
    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = new MyDate(birthday);
    }

    public Employee(Employee pEmployee) {
        this.name = pEmployee.name;
        this.birthday = new MyDate(pEmployee.birthday);
    }

    public void setBirthday(MyDate pBirthday) {
        birthday = new MyDate(pBirthday);
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        // call the instance's toString (or let concatenation do it for us)
        return "Name: " + this.name + ", Birthday: " + birthday;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Arwin", new MyDate(1, 1, 2000));
        Employee emp2 = new Employee(emp1);
        emp1.setBirthday(new MyDate(2, 2, 2022));
        System.out.println(emp1);
        System.out.println(emp2);
    }
}
