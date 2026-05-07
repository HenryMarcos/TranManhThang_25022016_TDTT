import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MathUtilsTest {

    @BeforeAll
    public static void setup() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("=== Kết thúc ===");
    }

    // --- Test cases cho hàm max ---
    @Test
    @DisplayName("Test max: a > b")
    void testMaxAGreaterThanB() {
        assertEquals(10, MathUtils.max(10, 5));
    }

    @Test
    @DisplayName("Test max: a = b")
    void testMaxAEqualsB() {
        assertEquals(7, MathUtils.max(7, 7));
    }

    @Test
    @DisplayName("Test max: a < b")
    void testMaxALessThanB() {
        assertEquals(8, MathUtils.max(3, 8));
    }

    @Test
    @DisplayName("Test max: Biên Integer.MAX_VALUE")
    void testMaxBoundaryUpper() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 100));
    }

    @Test
    @DisplayName("Test max: Biên Integer.MIN_VALUE")
    void testMaxBoundaryLower() {
        assertEquals(-100, MathUtils.max(-100, Integer.MIN_VALUE));
    }

    // --- Test cases cho hàm divide ---
    @Test
    @DisplayName("Test divide: b > 0")
    void testDividePositive() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    @DisplayName("Test divide: b < 0")
    void testDivideNegative() {
        assertEquals(-5, MathUtils.divide(10, -2));
    }

    @Test
    @DisplayName("Test divide: b = 0 ném ngoại lệ")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });
        assertEquals("Divider must not be zero", exception.getMessage());
    }
}