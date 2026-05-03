import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    @Test
    void testAdd() {
        // Kiểm tra xem 2 + 3 có đúng bằng 5 không
        assertEquals(5, MathUtils.add(2, 3), "Phép cộng phải trả về kết quả chính xác");
    }
}
