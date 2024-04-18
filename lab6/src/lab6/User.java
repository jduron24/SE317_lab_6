package lab6;
import java.util.*;

// Class representing a user of the ATM system
class User {
    private BankAccount checkingAccount;
    private BankAccount savingAccount;
    private String username;
    String password;
    String pin;

    // Constructor to initialize user with username, password, and PIN
    public User(String username, String password, String pin) {
        this.username = username;
        this.password = password;
        this.pin = pin;
        // Initialize checking and saving accounts with default balances and limits
        this.checkingAccount = new BankAccount(0, 5000, 500);
        this.savingAccount = new BankAccount(0, 5000, 0);
    }
    // Method to get the balance of the checking account
    public double getCheckingAccount() {
        return checkingAccount.getBalance();
    }
    // Method to withdraw money from the checking account
    public void withdrawFromCheckings(double amount) {
        checkingAccount.withdraw(amount);
    }
    // Method to transfer money from the checking account to the savings account
    public void transferCheckingsToSavings(double amount) {
        checkingAccount.transferToSaving(amount, savingAccount);
    }

    // Method to deposit money into the checking account
    public void depositToChecking(double amount) {
        checkingAccount.deposit(amount);
    }
    // Method to deposit money into the savings account
    public void depositToSaving(double amount) {
        savingAccount.deposit(amount);
    }
    // Method to transfer money from the savings account to the checking account
    public void transferSavingsToCheckings(double amount) {
        savingAccount.transferToChecking(amount, checkingAccount);
    }
    // Method to get the balance of the savings account
    public double getSavingsAccount() {
        return savingAccount.getBalance();
    }
    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password + ", PIN: " + pin;
    }
    
    // Getters for username and password
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
}
