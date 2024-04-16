package lab6;
import java.util.*;

// Class representing a bank account
public class BankAccount {
    private double balance;
    private double dailyDepositLimit;
    private double dailyWithdrawalLimit;

    // Constructor to initialize a bank account with balance and daily limits
    public BankAccount(double balance, double dailyDepositLimit, double dailyWithdrawalLimit) {
        this.balance = balance;
        this.dailyDepositLimit = dailyDepositLimit;
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }
    // Method to get the current balance of the account
    public double getBalance() {
        return balance;
    }
    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount <= dailyDepositLimit) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount exceeds daily limit.");
        }
    }
    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= dailyWithdrawalLimit && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Withdrawal amount exceeds daily limit or insufficient funds.");
        }
    }
    // Method to transfer money from this account to a saving account
    public void transferToSaving(double amount, BankAccount savingAccount) {
        if (amount <= balance) {
            balance -= amount;
            savingAccount.deposit(amount);
            System.out.println("Transfer successful. New checking balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
    // Method to transfer money from this account to a checking account
    public void transferToChecking(double amount, BankAccount checkingAccount) {
        if (amount <= balance && amount <= 100) {
            balance -= amount;
            checkingAccount.deposit(amount);
            System.out.println("Transfer successful. New saving balance: $" + balance);
        } else {
            System.out.println("Transfer amount exceeds balance or daily limit.");
        }
    }
}
