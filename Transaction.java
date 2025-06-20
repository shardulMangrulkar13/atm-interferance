package com.example.atm;

/**
 * Transaction class to represent individual banking transactions
 * Stores transaction details including timestamp, type, amount, and resulting balance
 */
public class Transaction {
    private String dateTime;
    private String type;
    private double amount;
    private double balanceAfter;

    public Transaction(String dateTime, String type, double amount, double balanceAfter) {
        this.dateTime = dateTime;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    // Getters
    public String getDateTime() {
        return dateTime;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | $%.2f | Balance: $%.2f",
            dateTime, type, amount, balanceAfter);
    }
}