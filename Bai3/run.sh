#!/bin/bash
echo "🚀 Đang bắt đầu quy trình xác minh build tự động (CI)..."

# Cấp quyền thực thi cho Maven Wrapper nếu chưa có
chmod +x mvnw

# Thực hiện pha test và package
./mvnw clean test package

if [ $? -eq 0 ]; then
    echo "✅ CI/CD Local: Test và Package thành công!"
    echo "📦 File JAR đã được tạo trong thư mục target/."
else
    echo "❌ CI/CD Local: Build thất bại. Vui lòng kiểm tra lại logs."
    exit 1
fi