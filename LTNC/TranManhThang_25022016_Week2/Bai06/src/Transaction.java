public class Transaction {
    private final String transactionId;
    private final double amount;
    private final String timestamp;

    public Transaction(String transactionId, double amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    /**
     * Convenience constructor that presets the timestamp to now.
     */
    public Transaction(String transactionId, double amount) {
        this(transactionId, amount, java.time.Instant.now().toString());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + transactionId + '\'' +
                ", amount=" + amount +
                ", ts='" + timestamp + '\'' +
                '}';
    }
}
