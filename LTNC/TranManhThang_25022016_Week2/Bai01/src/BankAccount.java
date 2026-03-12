public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount(String accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            this.balance = 0;
            System.err.println("Error: Balance can't be smaller than 0");
        } else this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.err.println("Error: deposit amount can't be smaller than 0");
            return;
        }
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }
    public static void main(String[] args) {
        BankAccount bank_account = new BankAccount("111", "Henry");
        bank_account.deposit(-10);
        if (bank_account.withdraw(10)) {
            System.out.println("Withdraw succeed!");
        } else System.err.println("Withdraw failed!");
        bank_account.deposit(10);
        if (bank_account.withdraw(5)) {
            System.out.println("Withdraw succeed!");
        }
    }
}