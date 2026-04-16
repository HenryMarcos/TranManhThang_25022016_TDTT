public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                bankAccount.deposit(100);
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                bankAccount.withdraw(100);
            }
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + bankAccount.getBalance());
    }
}
