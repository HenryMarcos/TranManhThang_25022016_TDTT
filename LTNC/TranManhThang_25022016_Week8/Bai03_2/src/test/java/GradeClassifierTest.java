import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GradeClassifierTest {

    @Test
    @DisplayName("Kiểm tra các điểm ranh giới và phân vùng hợp lệ")
    void testValidGrades() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.4));
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
        assertEquals("Khá", GradeClassifier.classifyGrade(7.9));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    @Test
    @DisplayName("Kiểm tra ngoại lệ cho giá trị biên ngoài")
    void testInvalidGrades() {
        // Kiểm tra gpa = -0.1
        IllegalArgumentException exLow = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(-0.1);
        });
        assertEquals("GPA không hợp lệ: -0.1", exLow.getMessage());

        // Kiểm tra gpa = 10.1
        IllegalArgumentException exHigh = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(10.1);
        });
        assertEquals("GPA không hợp lệ: 10.1", exHigh.getMessage());
    }
}