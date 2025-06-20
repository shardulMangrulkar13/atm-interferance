package com.example.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Account class to represent a bank account
 * Contains account information and transaction history
 */
public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactionHistory;
    private DateTimeFormatter dateFormatter;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Add initial balance as first transaction
        addTransaction("Initial Deposit", initialBalance, balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawal", -amount, balance);
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount, balance);
        }
    }

    private void addTransaction(String type, double amount, double balanceAfter) {
        Transaction transaction = new Transaction(
            LocalDateTime.now().format(dateFormatter),
            type,
            amount,
            balanceAfter
        );
        transactionHistory.add(transaction);
    }

    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    TRANSACTION HISTORY                        ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Date/Time           │ Type         │ Amount      │ Balance    ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");

        // Show last 10 transactions
        int start = Math.max(0, transactionHistory.size() - 10);
        for (int i = start; i < transactionHistory.size(); i++) {
            Transaction t = transactionHistory.get(i);
            System.out.printf("║ %-19s │ %-12s │ %,8.2f │ %,10.2f ║%n",
                t.getDateTime(),
                t.getType(),
                t.getAmount(),
                t.getBalanceAfter()
            );
        }
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        if (transactionHistory.size() > 10) {
            System.out.println("(Showing last 10 transactions)");
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return copy for security
    }
}