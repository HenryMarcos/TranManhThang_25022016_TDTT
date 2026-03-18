import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeAmount = scanner.nextInt();
        scanner.nextLine();
        Employee[] employees = new Employee[employeeAmount];

        for (int i = 0; i < employees.length; i++) {
            String employeeType = scanner.nextLine().trim();
            String employeeName = scanner.nextLine();

            String cleanedName = employeeName.replaceAll("\"", "");
            switch (employeeType) {
                case "F":
                    double baseSalary = scanner.nextDouble();
                    double bonus = scanner.nextDouble();
                    double penalty = scanner.nextDouble();
                    scanner.nextLine();
                    employees[i] = new FullTimeEmployee(cleanedName, baseSalary, bonus, penalty);
                    break;
                case "P":
                    double workingHours = scanner.nextDouble();
                    double hourlyRate = scanner.nextDouble();
                    scanner.nextLine();
                    employees[i] = new PartTimeEmployee(cleanedName, workingHours, hourlyRate);
                    break;
                default:
                    // If input doesn't match F or P, mark as a placeholder to avoid null
                    System.out.println("Unknown type: " + employeeType);
                    break;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}
