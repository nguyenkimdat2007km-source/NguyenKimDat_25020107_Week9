#!/bin/bash

echo "========================================="
echo "🚀 BƯỚC 1: CẤP QUYỀN THỰC THI CHO MAVEN WRAPPER"
echo "========================================="
# Đảm bảo file mvnw có quyền chạy trên hệ thống
chmod +x mvnw

echo "========================================="
echo "🚀 BƯỚC 2: CHẠY KIỂM THỬ VÀ ĐO LƯỜNG ĐỘ BAO PHỦ (JACOCO)"
echo "========================================="
# Lệnh 'verify' sẽ chạy test, tạo báo cáo và kiểm tra luật strict rule > 80%
./mvnw clean verify

# Kiểm tra mã thoát (exit code)
if [ $? -eq 0 ]; then
    echo ""
    echo "✅ CHÚC MỪNG! BẠN ĐÃ VƯỢT QUA BÀI KIỂM TRA CHẤT LƯỢNG!"
    echo "Độ bao phủ code (Coverage) đã đạt tiêu chuẩn (>80%)."
    echo "Bạn có thể mở file báo cáo giao diện web tại: target/site/jacoco/index.html"
else
    echo ""
    echo "❌ BẢN BUILD THẤT BẠI!"
    echo "Lý do: Có thể do Test chạy sai hoặc độ bao phủ code bị tụt xuống dưới 80%."
    echo "Vui lòng cuộn lên trên để xem chi tiết lỗi."
    exit 1
fi