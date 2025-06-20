package com.example.atm;

import java.util.Scanner;

/**
 * ATM Interface Simulation
 * A simple console-based ATM system
 * Author: Your Name
 * Version: 1.0
 */
public class ATMInterface {
    private Account currentAccount;
    private Scanner scanner;
    private boolean isRunning;

    public ATMInterface() {
        scanner = new Scanner(System.in);
        isRunning = true;
        // Initialize with a demo account
        currentAccount = null;
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        atm.run();
    }

    public void run() {
        displayWelcome();

        while (isRunning) {
            if (currentAccount == null) {
                handleLogin();
            } else {
                showMainMenu();
                handleMainMenuChoice();
            }
        }

        scanner.close();
        System.out.println("Thank you for using our ATM service!");
    }

    private void displayWelcome() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          WELCOME TO ATM              ║");
        System.out.println("║      Secure Banking System          ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    private void handleLogin() {
        System.out.println("\n--- ATM LOGIN ---");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Simple validation (in real system, this would check against database)
        if (validateCredentials(accountNumber, pin)) {
            currentAccount = new Account(accountNumber, "Shardul Mangrulkar", 5000.00);
            System.out.println("\n✓ Login Successful!");
            System.out.println("Welcome, " + currentAccount.getAccountHolderName());
        } else {
            System.out.println("\n✗ Invalid credentials. Please try again.");
            System.out.println("Demo Account Number: 123456789");
            System.out.println("Demo PIN: 1234");
        }
    }

    private boolean validateCredentials(String accountNumber, String pin) {
        // Demo credentials - in real system, this would be encrypted and stored securely
        return "123456789".equals(accountNumber) && "1234".equals(pin);
    }

    private void showMainMenu() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║            MAIN MENU                ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Check Balance                    ║");
        System.out.println("║ 2. Withdraw Cash                    ║");
        System.out.println("║ 3. Deposit Cash                     ║");
        System.out.println("║ 4. Transfer Money                   ║");
        System.out.println("║ 5. Transaction History              ║");
        System.out.println("║ 6. Change PIN                       ║");
        System.out.println("║ 7. Logout                           ║");
        System.out.println("║ 8. Exit                             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Select an option (1-8): ");
    }

    private void handleMainMenuChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash();
                    break;
                case 3:
                    depositCash();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    changePIN();
                    break;
                case 7:
                    logout();
                    break;
                case 8:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select 1-8.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void checkBalance() {
        System.out.println("\n--- BALANCE INQUIRY ---");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Account Holder: " + currentAccount.getAccountHolderName());
        System.out.printf("Current Balance:INR %.2f%n", currentAccount.getBalance());
        pressEnterToContinue();
    }

    private void withdrawCash() {
        System.out.println("\n--- CASH WITHDRAWAL ---");
        System.out.printf("Current Balance: INR)%.2f%n", currentAccount.getBalance());
        System.out.print("Enter withdrawal amount:INR)");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount > currentAccount.getBalance()) {
                System.out.println("Insufficient funds. Transaction cancelled.");
            } else if (amount > 1000) {
                System.out.println("Daily withdrawal limit is INR)1000. Transaction cancelled.");
            } else {
                currentAccount.withdraw(amount);
                System.out.printf("✓ Withdrawal successful! Please take your cash: INR)%.2f%n", amount);
                System.out.printf("Remaining balance: INR)%.2f%n", currentAccount.getBalance());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
        }
        pressEnterToContinue();
    }

    private void depositCash() {
        System.out.println("\n--- CASH DEPOSIT ---");
        System.out.print("Enter deposit amount: INR");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount > 10000) {
                System.out.println("Maximum deposit limit is INR)10,000 per transaction.");
            } else {
                currentAccount.deposit(amount);
                System.out.printf("✓ Deposit successful! Amount deposited: INR%.2f%n", amount);
                System.out.printf("New balance: INR)%.2f%n", currentAccount.getBalance());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
        }
        pressEnterToContinue();
    }

    private void transferMoney() {
        System.out.println("\n--- MONEY TRANSFER ---");
        System.out.print("Enter recipient account number: ");
        String recipientAccount = scanner.nextLine();

        System.out.print("Enter transfer amount: INR");
        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount > currentAccount.getBalance()) {
                System.out.println("Insufficient funds. Transfer cancelled.");
            } else {
                currentAccount.withdraw(amount);
                System.out.printf("✓ Transfer successful!%n");
                System.out.printf("Amount transferred: INR)%.2f%n", amount);
                System.out.printf("To account: %s%n", recipientAccount);
                System.out.printf("Remaining balance: INR)%.2f%n", currentAccount.getBalance());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
        }
        pressEnterToContinue();
    }

    private void showTransactionHistory() {
        System.out.println("\n--- TRANSACTION HISTORY ---");
        currentAccount.displayTransactionHistory();
        pressEnterToContinue();
    }

    private void changePIN() {
        System.out.println("\n--- CHANGE PIN ---");
        System.out.print("Enter current PIN: ");
        String currentPIN = scanner.nextLine();

        if (!"1234".equals(currentPIN)) {
            System.out.println("Incorrect current PIN.");
            return;
        }

        System.out.print("Enter new PIN (4 digits): ");
        String newPIN = scanner.nextLine();

        if (newPIN.length() != 4 || !newPIN.matches("\\d{4}")) {
            System.out.println("PIN must be exactly 4 digits.");
        } else {
            System.out.println("✓ PIN changed successfully!");
        }
        pressEnterToContinue();
    }

    private void logout() {
        System.out.println("\n--- LOGOUT ---");
        System.out.println("Thank you, " + currentAccount.getAccountHolderName());
        System.out.println("You have been logged out successfully.");
        currentAccount = null;
        pressEnterToContinue();
    }

    private void pressEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}