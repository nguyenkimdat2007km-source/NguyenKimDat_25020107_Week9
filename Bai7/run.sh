#!/bin/bash

# 1. Đảm bảo file chạy của Maven có quyền thực thi
chmod +x mvnw

echo "===================================================="
echo "🔍 Đang kiểm tra Checkstyle & Unit Test cho Bài 7..."
echo "===================================================="

# 2. Chạy quét Checkstyle trước
# Lệnh này sẽ kiểm tra xem code có 'xanh' theo chuẩn Google không
./mvnw checkstyle:check

if [ $? -eq 0 ]; then
    echo "✅ CHECKSTYLE: Đạt chuẩn! Không có lỗi định dạng."
else
    echo "❌ CHECKSTYLE: Thất bại! Hãy sửa lỗi format trước khi push."
    exit 1
fi

echo "----------------------------------------------------"

# 3. Chạy Unit Test (JUnit 5)
./mvnw test

if [ $? -eq 0 ]; then
    echo "✅ TEST: Vượt qua toàn bộ các bài thử nghiệm!"
else
    echo "❌ TEST: Thất bại! Hãy kiểm tra lại logic trong code."
    exit 1
fi

echo "===================================================="
echo "🚀 Nhóm 25 đã sẵn sàng để Push và tạo Pull Request!"
echo "===================================================="