public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public BankAccount() {
        this(0);
    }

    public synchronized boolean deposit(int money) {
        balance += money;
        return true;
    }

    public synchronized boolean withdraw(int money) {
        if (money > balance) return false;
        balance -= money;
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
