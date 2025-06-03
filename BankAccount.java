package BankAccountDemo;

public class BankAccount {

	 // Private data members (encapsulated)
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String password;  

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.password = password;
    }

    // Public getter methods (controlled access)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    // No direct getter for balance/password
    public double getBalance(String inputPassword) {
        if (authenticate(inputPassword)) {
            return balance;
        }
        System.out.println("Authentication failed!");
        return -1;  // Indicates error
    }

    // Setter with validation
    public void setAccountHolderName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            accountHolderName = newName;
        } else {
            System.out.println("Invalid name!");
        }
    }

    // Business methods with access control
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount, String inputPassword) {
        if (!authenticate(inputPassword)) {
            System.out.println("Authentication failed!");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword)) {
            password = newPassword;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Old password incorrect!");
        }
    }

    // Private helper method (implementation hiding)
    private boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);  // In real apps, compare hashes
    }
}
