package com.banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    @Test
    void testWithdrawRules() {
        // Khởi tạo tài khoản tiết kiệm với 10000.0
        SavingsAccount account = new SavingsAccount(1001L, 10000.0);

        // 1. Rút 500.0 (Hợp lệ vì < 1000.0 và số dư sau rút > 5000.0)
        account.withdraw(500.0);
        assertEquals(9500.0, account.getBalance(), "Số dư còn lại phải là 9500.0");

        // 2. Rút 5000.0 (KHÔNG hợp lệ vì > 1000.0 hạn mức rút tối đa)[cite: 22]
        account.withdraw(5000.0);
        assertEquals(9500.0, account.getBalance(), "Số dư không đổi do rút quá hạn mức 1000.0");

        // 3. Rút 900.0 nhưng khiến số dư còn lại < 5000.0 (Giả sử bạn đã rút nhiều lần trước đó)
        // Trong trường hợp này, 9500 - 5000 = 4500 (vi phạm mức tối thiểu 5000.0)[cite: 22]
        account.withdraw(5000.0); // Thử rút số tiền lớn để vi phạm min balance
        assertEquals(9500.0, account.getBalance(), "Số dư không đổi do vi phạm mức duy trì 5000.0");
    }
}