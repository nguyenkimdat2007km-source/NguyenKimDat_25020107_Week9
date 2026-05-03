package com.practice.matrix;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePathManagerTest {
    @Test
    public void testBuildPathCrossPlatform() {
        FilePathManager manager = new FilePathManager();

        // Gọi hàm của bạn để tạo đường dẫn
        String result = manager.buildPath("data", "output.txt");

        // Dùng chuẩn của chính hệ điều hành đang chạy test để làm đáp án so sánh
        String expected = Paths.get("data", "output.txt").toString();

        // So sánh 2 kết quả
        assertEquals(expected, result, "Đường dẫn phải tự động khớp với định dạng của OS hiện tại");
    }
}