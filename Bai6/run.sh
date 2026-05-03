#!/bin/bash

# 1. Cấp quyền thực thi cho Maven Wrapper (phòng trường hợp file bị mất quyền)
chmod +x mvnw

echo "=========================================="
echo "🚀 Đang bắt đầu Build và Test cho Bài 6..."
echo "=========================================="

# 2. Thực hiện dọn dẹp và chạy Unit Test
./mvnw clean test

# 3. Kiểm tra kết quả thực thi
if [ $? -eq 0 ]; then
    echo ""
    echo "------------------------------------------"
    echo "✅ KẾT QUẢ: Toàn bộ Test đã VƯỢT QUA!"
    echo "------------------------------------------"
else
    echo ""
    echo "------------------------------------------"
    echo "❌ KẾT QUẢ: Có lỗi trong quá trình Test."
    echo "------------------------------------------"
    exit 1
fi