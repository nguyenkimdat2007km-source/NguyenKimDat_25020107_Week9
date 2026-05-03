package com.practice.matrix;

import java.nio.file.Paths;

public class FilePathManager {
    /**
     * Hàm nối tên thư mục và tên file thành một đường dẫn hoàn chỉnh.
     */
    public String buildPath(String folder, String fileName) {
        // Paths.get() sẽ tự động dùng "\" trên Windows và "/" trên Linux/macOS
        return Paths.get(folder, fileName).toString();
    }
}