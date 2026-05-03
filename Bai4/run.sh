#!/bin/bash

echo "========================================="
echo "🚀 BƯỚC 1: CẤP QUYỀN THỰC THI CHO MAVEN WRAPPER"
echo "========================================="
# Đảm bảo file mvnw có quyền chạy trên hệ thống (đặc biệt quan trọng với Linux/macOS)
chmod +x mvnw

echo "========================================="
echo "🚀 BƯỚC 2: CHẠY KIỂM THỬ ĐA NỀN TẢNG (MATRIX TEST)"
echo "========================================="
# Thực hiện dọn dẹp và chạy các Unit Test
./mvnw clean test

# Kiểm tra mã thoát (exit code) của lệnh test phía trên
if [ $? -eq 0 ]; then
    echo ""
    echo "✅ QUÁ TRÌNH KIỂM THỬ THÀNH CÔNG!"
    echo "Code đã xử lý đường dẫn chuẩn xác bằng java.nio.file.Paths."
    echo "Có thể yên tâm commit và push lên GitHub để chạy CI/CD Matrix Strategy."
else
    echo ""
    echo "❌ KIỂM THỬ THẤT BẠI!"
    echo "Vui lòng cuộn lên trên để xem chi tiết lỗi (Error trace)."
    exit 1
fi