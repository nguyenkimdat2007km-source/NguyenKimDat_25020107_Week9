import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    // Tạo logger từ thư viện Logback
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public static int add(int a, int b) {
        // Ghi log thay vì dùng System.out.println
        logger.info("Đang thực hiện phép cộng: {} + {}", a, b);
        return a + b;
    }
}
