import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Khởi tạo tài khoản với số dư 500 trước mỗi phương thức @Test
        account = new BankAccount("123456", "Nguyen Van A", 500.0);
    }

    // --- Test cho hàm deposit ---
    @Test
    @DisplayName("Nạp tiền hợp lệ")
    void testDepositValid() {
        account.deposit(200.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    @DisplayName("Nạp tiền bằng 0 gây ngoại lệ")
    void testDepositZero() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    @DisplayName("Nạp tiền âm gây ngoại lệ")
    void testDepositNegative() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    // --- Test cho hàm withdraw ---
    @Test
    @DisplayName("Rút tiền thành công trong hạn mức")
    void testWithdrawSuccess() {
        boolean result = account.withdraw(200.0);
        assertTrue(result);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    @DisplayName("Rút toàn bộ số dư")
    void testWithdrawFullBalance() {
        assertTrue(account.withdraw(500.0));
        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Rút vượt quá số dư (thất bại)")
    void testWithdrawOverBalance() {
        boolean result = account.withdraw(500.01);
        assertFalse(result);
        assertEquals(500.0, account.getBalance()); // Số dư không đổi
    }

    @Test
    @DisplayName("Rút tiền giá trị âm gây ngoại lệ")
    void testWithdrawNegative() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    // --- Test tính nhất quán theo trình tự ---
    @Test
    @DisplayName("Kiểm tra tính nhất quán theo chuỗi thao tác")
    void testAccountConsistency() {
        // 1. Khởi tạo số dư = 0
        BankAccount acc = new BankAccount("999", "Test User", 0.0);
        assertEquals(0.0, acc.getBalance());

        // 2. Nạp 500
        acc.deposit(500.0);
        assertEquals(500.0, acc.getBalance());

        // 3. Rút 200 (thành công)
        boolean firstWithdraw = acc.withdraw(200.0);
        assertTrue(firstWithdraw);
        assertEquals(300.0, acc.getBalance());

        // 4. Rút 400 (thất bại)
        boolean secondWithdraw = acc.withdraw(400.0);
        assertFalse(secondWithdraw);

        // 5. Kiểm tra số dư cuối cùng phải là 300
        assertEquals(300.0, acc.getBalance());
    }
}