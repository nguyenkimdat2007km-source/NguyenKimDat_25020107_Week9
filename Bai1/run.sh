#!/bin/bash

echo "🚀 Bắt đầu quá trình Build dự án MathUtils..."

# Dọn dẹp thư mục target cũ (nếu có)
echo "🧹 Đang dọn dẹp (mvn clean)..."
./mvnw clean

# Biên dịch code và chạy toàn bộ bài test bằng JUnit 5
echo "🧪 Đang biên dịch và thực thi Test (mvn test)..."
./mvnw test

# Kiểm tra kết quả của lệnh mvn test vừa chạy
if [ $? -eq 0 ]; then
    echo "========================================="
    echo "✅ BUILD VÀ TEST THÀNH CÔNG!"
    echo "========================================="
else
    echo "========================================="
    echo "❌ BUILD HOẶC TEST THẤT BẠI!"
    echo "Vui lòng cuộn lên trên để xem chi tiết lỗi."
    echo "========================================="
fi