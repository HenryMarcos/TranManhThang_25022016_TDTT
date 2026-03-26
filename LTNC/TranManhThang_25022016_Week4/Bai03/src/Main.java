import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int employeeAmount = sc.nextInt();
        sc.nextLine();

        Employee[] employeeList = new Employee[employeeAmount];

        for (int i = 0; i < employeeAmount; i++) {
            String employeeType = sc.next();
            String employeeId = sc.next();
            String employeeName = sc.next();
            double baseSalary = sc.nextDouble();

            switch (employeeType) {
                case "O":
                    employeeList[i] = new OfficeWorker(employeeId, employeeName, baseSalary);
                    break;
                case "T":
                    int overtimeHours = sc.nextInt();
                    employeeList[i] = new Technician(employeeId, employeeName, baseSalary, overtimeHours);
                    break;
                default:
                    break;
            }

            sc.nextLine();
        }

        double totalPay = 0;

        for (int i = 0; i < employeeAmount; i++) {
            totalPay += employeeList[i].calculatePay();
            System.out.println(employeeList[i]);
            employeeList[i].work();
            System.out.println();
        }

        DecimalFormat df = new DecimalFormat("#0.0");

        System.out.println("Total Pay = " + df.format(totalPay));
    }
}
