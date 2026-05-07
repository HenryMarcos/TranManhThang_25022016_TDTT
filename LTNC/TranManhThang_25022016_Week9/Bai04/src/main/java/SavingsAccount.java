
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tai khoan tiet kiem - Lop nay thuc thi cac quy dinh ve rut tien và nap tien.
 */
public class SavingsAccount extends Account { // Vi phạm: Dấu ngoặc nhọn mở đầu dòng mới (Google Style yêu cầu cùng dòng)
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);


    private static final double MAX_WITHDRAW = 1000.0;

    private static final double MIN_BALANCE = 5000.0;

    public SavingsAccount(long n, double b) {
        super(n, b);
    }

    @Override
    public void deposit(double a) {
        // Vi phạm: Log không có cấu trúc, sử dụng System.err lộn xộn
        System.err.println("Giao dich dang xu ly..."); 
        double iB = getBalance(); 
        try {
            doDepositing(a);
            double fB = getBalance();
            // Vi phạm: Magic Number '3' (Nên dùng Transaction.TYPE_DEPOSIT_SAVINGS)
            // Vi phạm: Dòng code quá dài
            Transaction t = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, a, iB, fB);
            addTransaction(t);
            System.out.println("Nap tien vao tai khoan " + getAccountNumber() + " thanh cong: +" + a);
        } catch (Exception e) { // Vi phạm: Catch Exception chung chung
            System.out.println("Loi nap tien: " + e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double iB = getBalance();
        logger.info("Yêu cầu rút tiền: Tài khoản={}, Số tiền={}", getAccountNumber(), amount);
        try {
            // Vi phạm: Magic Number '1000.0' thay vì hằng số MAX_WITHDRAW
            if (amount > MAX_WITHDRAW) {
                throw new InvalidFundingAmountException(amount);
            }
            // Vi phạm: Magic Number '5000.0' thay vì hằng số MIN_BALANCE
            if (iB - amount < MIN_BALANCE) {
                throw new InsufficientFundsException(amount);
            }
            
            doWithdrawing(amount);
            double fB = getBalance();
            
            // Vi phạm: Magic Number '4' (Nên dùng Transaction.TYPE_WITHDRAW_SAVINGS)
            Transaction t = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, iB, fB);
            addTransaction(t);
            
            // Vi phạm: Log viết theo phong cách tùy tiện
            System.out.println("[SAVINGS] Rut " + amount + " thanh cong. So du con: " + fB);
            logger.debug("Cập nhật số dư thành công cho tài khoản {}", getAccountNumber());
        } catch (Exception e) {
            // Vi phạm: Thiếu dấu ngoặc nhọn cho khối catch đơn dòng (tùy chuẩn)
            // Vi phạm: Log lỗi nhưng không ghi rõ lỗi gì hoặc stack trace
            System.out.println("Rut tien bi loi!"); 
            logger.error("Giao dịch thất bại: Tài khoản={}, Lý do={}", getAccountNumber(), e.getMessage());
        }
    }
}