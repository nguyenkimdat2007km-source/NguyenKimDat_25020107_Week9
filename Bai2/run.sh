#!/bin/bash

set -e

echo "========================================="
echo "  BẮT ĐẦU BIÊN DỊCH VÀ KIỂM TRA CODE     "
echo "========================================="

# Đảm bảo file mvnw có quyền thực thi
chmod +x mvnw

# 1. Dọn dẹp và biên dịch dự án bằng Maven Wrapper
echo "=> Đang chạy: ./mvnw clean compile..."
./mvnw clean compile

# 2. Chạy kiểm tra định dạng code (Checkstyle)
echo "=> Đang kiểm tra Checkstyle..."
set +e
./mvnw checkstyle:check
CHECKSTYLE_STATUS=$?
set -e

# 3. Xử lý kết quả Checkstyle và chạy ứng dụng
echo "========================================="
if [ $CHECKSTYLE_STATUS -eq 0 ]; then
    echo "✅ CHECKSTYLE PASS! Code đã đúng chuẩn."
    echo "=> Đang khởi chạy BankSystem..."
    echo "-----------------------------------------"
    ./mvnw exec:java -Dexec.mainClass="com.banksystem.Main"
else
    echo "❌ CHECKSTYLE FAILED! Phát hiện vi phạm định dạng code."
    echo "Vui lòng xem log phía trên, sửa lại các lỗi thụt lề, đặt tên biến..."
    echo "rồi chạy lại lệnh ./run.sh"
    exit 1
fi
echo "========================================="