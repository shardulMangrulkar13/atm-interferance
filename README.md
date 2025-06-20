# ATM Interface Simulation

A comprehensive console-based ATM (Automated Teller Machine) simulation written in Java. This project demonstrates object-oriented programming principles, user interface design, and basic banking operations.

## Features

### 🏧 Core ATM Functions
- **User Authentication**: Secure login with account number and PIN
- **Balance Inquiry**: Check current account balance
- **Cash Withdrawal**: Withdraw money with daily limits
- **Cash Deposit**: Deposit money into account
- **Money Transfer**: Transfer funds to other accounts
- **Transaction History**: View recent transaction records
- **PIN Change**: Update account PIN for security

### 🔒 Security Features
- PIN-based authentication
- Transaction limits (withdrawal: $1000, deposit: $10,000)
- Input validation and error handling
- Secure logout functionality

### 💻 User Interface
- Professional ASCII art interface
- Clear menu navigation
- Formatted transaction displays
- User-friendly error messages

## Project Structure

```
src/
├── com/
│   └── example/
│       └── atm/
│           ├── ATMInterface.java    # Main application class
│           ├── Account.java         # Account management
│           └── Transaction.java     # Transaction records
├── README.md
└── .gitignore
```

## Class Design

### ATMInterface.java
- Main application controller
- Handles user interactions
- Manages login/logout flow
- Processes all ATM operations

### Account.java
- Represents a bank account
- Manages balance and transactions
- Maintains transaction history
- Provides account information

### Transaction.java
- Represents individual transactions
- Stores transaction details
- Provides transaction formatting

## Demo Credentials

For testing purposes, use these credentials:
- **Account Number**: `123456789`
- **PIN**: `1234`
- **Initial Balance**: $5,000.00

## How to Run

### Prerequisites
- Java 8 or higher
- Command line interface

### Compilation and Execution

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/atm-interface.git
   cd atm-interface
   ```

2. **Compile the Java files**:
   ```bash
   javac src/com/example/atm/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp src com.example.atm.ATMInterface
   ```

## Usage Guide

### Login Process
1. Start the application
2. Enter account number: `123456789`
3. Enter PIN: `1234`
4. Access granted to main menu

### Available Operations

#### 1. Check Balance
- Displays current account balance
- Shows account holder information

#### 2. Withdraw Cash
- Enter withdrawal amount
- Validates sufficient funds
- Enforces daily withdrawal limit ($1,000)
- Updates balance and records transaction

#### 3. Deposit Cash
- Enter deposit amount
- Validates positive amount
- Enforces deposit limit ($10,000)
- Updates balance and records transaction

#### 4. Transfer Money
- Enter recipient account number
- Enter transfer amount
- Validates sufficient funds
- Processes transfer and updates balance

#### 5. Transaction History
- Displays last 10 transactions
- Shows date, type, amount, and resulting balance
- Formatted table display

#### 6. Change PIN
- Requires current PIN verification
- Validates new PIN format (4 digits)
- Updates account security

#### 7. Logout
- Securely ends current session
- Returns to login screen

#### 8. Exit
- Terminates the application

## Sample Output

```
╔══════════════════════════════════════╗
║          WELCOME TO ATM              ║
║      Secure Banking System          ║
╚══════════════════════════════════════╝

--- ATM LOGIN ---
Enter Account Number: 123456789
Enter PIN: 1234

✓ Login Successful!
Welcome, John Doe

╔══════════════════════════════════════╗
║            MAIN MENU                ║
╠══════════════════════════════════════╣
║ 1. Check Balance                    ║
║ 2. Withdraw Cash                    ║
║ 3. Deposit Cash                     ║
║ 4. Transfer Money                   ║
║ 5. Transaction History              ║
║ 6. Change PIN                       ║
║ 7. Logout                           ║
║ 8. Exit                             ║
╚══════════════════════════════════════╝
```

## Technical Features

### Object-Oriented Design
- **Encapsulation**: Private fields with public getters
- **Abstraction**: Clear separation of concerns
- **Modularity**: Separate classes for different responsibilities

### Error Handling
- Input validation for all user entries
- Try-catch blocks for number parsing
- Boundary condition checks
- User-friendly error messages

### Data Management
- In-memory transaction storage
- ArrayList for transaction history
- Real-time balance updates
- Date/time stamping

## Future Enhancements

Potential improvements for this project:

### Database Integration
- Connect to MySQL/PostgreSQL database
- Persistent account storage
- Multiple user support

### Advanced Security
- Encrypted PIN storage
- Session timeouts
- Failed attempt lockouts
- Two-factor authentication

### Additional Features
- Account statements
- Bill payments
- Mobile number registration
- Email notifications
- Mini statements

### GUI Version
- JavaFX or Swing interface
- Card insertion simulation
- Receipt printing
- Touch screen simulation

## Learning Outcomes

This project helps understand:
- Object-oriented programming concepts
- User input validation
- Error handling strategies
- Menu-driven application design
- Banking system simulation
- Data formatting and display
- Security considerations in software

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Contact

Your Name - your.email@example.com

Project Link: [https://github.com/yourusername/atm-interface](https://github.com/yourusername/atm-interface)
