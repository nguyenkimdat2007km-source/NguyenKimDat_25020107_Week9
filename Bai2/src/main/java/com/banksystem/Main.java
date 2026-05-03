package com.banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("=== KHOI CHAY HE THONG NGAN HANG ===");

        // 1. Tao khach hang
        Customer dat = new Customer(25020107L, "Nguyen Kim Dat");

        // 2. Tao tai khoan (Vang lai va Tiet kiem)
        Account checking = new CheckingAccount(1001L, 5000.0);
        Account savings = new SavingsAccount(2002L, 10000.0);

        // 3. Them tai khoan vao danh sach cua khach hang
        dat.addAccount(checking);
        dat.addAccount(savings);

        logger.info("Khach hang: {}. Thong tin: {}", dat.getFullName(), dat.getCustomerInfo());

        try {
            // 4. Thuc hien giao dich mau
            logger.info("--- Thuc hien giao dich ---");
            checking.deposit(2000.0); // Nap 2000 vao tai khoan vang lai
            savings.withdraw(1000.0);  // Rut 1000 tu tai khoan tiet kiem

            // 5. In lich su giao dich
            logger.info("Lich su tai khoan Vang lai:\n{}", checking.getTransactionHistory());
            logger.info("Lich su tai khoan Tiet kiem:\n{}", savings.getTransactionHistory());

        } catch (Exception e) {
            logger.error("Da xay ra loi trong qua trinh giao dich: {}", e.getMessage());
        }

        logger.info("=== KET THUC CHUONG TRINH ===");
    }
}
