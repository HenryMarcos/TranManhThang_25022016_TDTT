public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;

    public Account(String accountId, double balance) {
        this(accountId, balance, new Transaction[0]);
    }

    public Account(String accountId, double balance, Transaction[] history) {
        this.accountId = accountId;
        this.balance = balance;
        // store a defensive copy to prevent external modification
        this.history = history == null ? new Transaction[0] : java.util.Arrays.copyOf(history, history.length);
    }

    /**
     * Returns a copy of the transaction history so callers cannot
     * modify the internal array directly.
     */
    public Transaction[] getHistory() {
        return java.util.Arrays.copyOf(history, history.length);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", historyCount=" + history.length +
                '}';
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction("deposit", 100);
        Transaction[] initial = {t1};
        Account account = new Account("123", 298, initial);

        // attempt to mutate returned history
        Transaction[] copy = account.getHistory();
        copy[0] = new Transaction("withdraw", 50);

        // original object remains unaffected
        System.out.println(account);
        System.out.println("returned history[0]=" + copy[0]);
        System.out.println("internal history[0]=" + account.getHistory()[0]);
    }
}
