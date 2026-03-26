import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int employeeAmount = sc.nextInt();
        sc.nextLine();

        Employee[] employeeList = new Employee[employeeAmount]; 

        for (int i = 0; i < employeeAmount; i++) {
            String employeeType = sc.next();
            String employeeName = sc.next();
            double baseSalary = sc.nextDouble();

            switch (employeeType) {
                case "E":
                    employeeList[i] = new Employee(employeeName, baseSalary);
                    break;
                case "D":
                    int overtimeHours = sc.nextInt();
                    employeeList[i] = new Developer(employeeName, baseSalary, overtimeHours);
                    break;
                case "T":
                    int bugsFound = sc.nextInt();
                    employeeList[i] = new Tester(employeeName, baseSalary, bugsFound);
                    break;
                default:
                    break;
            }
            sc.nextLine();
        }
        for (int i = 0; i < employeeAmount; i++) {
            System.out.println(employeeList[i]);
            if (employeeList[i] instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            }
            if (employeeList[i] instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
            System.out.println();
        }
    }
}
