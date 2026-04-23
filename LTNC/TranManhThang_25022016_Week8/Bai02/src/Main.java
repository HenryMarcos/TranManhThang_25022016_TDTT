public class Main {
    private static final double SOCIAL_INSURANCE_RATE = 0.08;
    private static final double HEALTH_INSURANCE_RATE = 0.015;
    private static final double PERSONAL_DEDUCTION = 11000000;

    private static final double TAX_LEVEL_1_LIMIT = 5000000;
    private static final double TAX_LEVEL_2_LIMIT = 10000000;

    private static final double TAX_RATE_LEVEL_1 = 0.05;
    private static final double TAX_RATE_LEVEL_2 = 0.10;

    private static final double TAX_BASE_LEVEL_2 = 250000; // 5tr * 5%
    private static final double TAX_BASE_LEVEL_3 = 750000; // 250k + 5tr * 10%

    private static double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }

    private static double calculateInsurance(double actualSalary) {
        // Biến trung gian tự giải thích
        double socialInsurance = actualSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * HEALTH_INSURANCE_RATE;
        return socialInsurance + healthInsurance;
    }

    private static double calculateTax(double actualSalary, double insurance, double taxRate) {
        double taxableIncome = actualSalary - insurance - PERSONAL_DEDUCTION;
        
        if (taxableIncome <= 0) return 0;

        if (taxableIncome <= TAX_LEVEL_1_LIMIT) {
            return taxableIncome * TAX_RATE_LEVEL_1;
        } else if (taxableIncome <= TAX_LEVEL_2_LIMIT) {
            return TAX_BASE_LEVEL_2 + (taxableIncome - TAX_LEVEL_1_LIMIT) * TAX_RATE_LEVEL_2;
        } else {
            return TAX_BASE_LEVEL_3 + (taxableIncome - TAX_LEVEL_2_LIMIT) * taxRate;
        }
    }

    public static void printPayroll(String name, double baseSalary,
                            int workDays, int totalDays,
                            double taxRate, double bonus) {
        System.out.println("=== BẢNG LƯƠNG ===");
        System.out.println("Nhân viên: " + name);

        

        double actualSalary = calculateActualSalary(baseSalary, workDays, totalDays);

        double insurance = calculateInsurance(actualSalary);

        double tax = calculateTax(actualSalary, insurance, taxRate);
        double netSalary = actualSalary - insurance - tax + bonus;

        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }
    public static void main(String[] args) {
        
        String name = "Nguyen Van A";
        double baseSalary = 30000000;
        int workDays = 22;
        int totalDays = 26;
        double taxRate = 0.15;
        double bonus = 2000000;

        // In output sau khi refactor
        printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }

}
