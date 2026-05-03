package com.banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingsAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        logger.debug("Giao dich dang xu ly...");
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction t = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(t);
            logger.info("Nap tien vao tai khoan {} thanh cong: +{}", getAccountNumber(), amount);
        } catch (Exception e) {
            logger.error("Loi nap tien: {}", e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            if (amount > 1000.0) {
                throw new InvalidFundingAmountException(amount);
            }
            if (initialBalance - amount < 5000.0) {
                throw new InsufficientFundsException(amount);
            }

            doWithdrawing(amount);
            double finalBalance = getBalance();

            Transaction t = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(t);

            logger.info("[SAVINGS] Rut {} thanh cong. So du con: {}", amount, finalBalance);
        } catch (Exception e) {
            logger.error("Rut tien bi loi! Chi tiet: {}", e.getMessage());
        }
    }
}