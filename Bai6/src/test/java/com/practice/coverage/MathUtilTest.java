package test.java.com.practice.coverage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilTest {
    @Test
    public void testMathOperations() {
        MathUtil math = new MathUtil();

        // Kiểm tra hàm cộng
        assertEquals(5, math.add(2, 3));

        // Kiểm tra hàm trừ
        assertEquals(1, math.subtract(3, 2));
    }
}