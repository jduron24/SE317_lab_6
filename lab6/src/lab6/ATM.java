package lab6;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Main ATM class
public class ATM {
	 private Map<String, User> users;
	 public static BankAccount checkingAccount;
	 public static BankAccount savingAccount;
	 // Constructor to initialize the ATM with an empty user map
	 public ATM() {
	     this.users = new HashMap<>();
	     checkingAccount = new BankAccount(100,500,500);
	     savingAccount = new BankAccount(100,200,200);
	 }	
// Method to register a new user
// public void registerUser(String username, String password,String pin) {
//     if (!users.containsKey(username)) {
//         users.put(username, new User(username, password, pin));
//         System.out.println("User registered successfully.");
//     } else {
//         System.out.println("Username already exists. Please choose another one.");
//     }
// }
 
 //1st refactor
 public void registerUser(String username, String password, String pin) {
	    if (username == null || username.isEmpty()) {
	        System.out.println("Invalid username. Cannot register user.");
	        return;
	    }
	    if (users.containsKey(username)) {
	        System.out.println("Username already exists. Please choose another one.");
	    } else {
	        users.put(username, new User(username, password, pin));
	        System.out.println("User registered successfully.");
	    }
	}
 
 
 public User getUser(String username) {
	    return users.get(username);
	}
 

//Method to login with username/password or pin
// public void login(String username, String password) { 
//	 boolean loggedIn = false;
//	for(User user : users.values()) {
//		if (user != null && (user.password.equals(password) || user.pin.equals(password)) && user.password.equals(password)) {
//	        System.out.println("Login successful");
//	        userChoice(user);
//	        loggedIn = true;
//	        break;
//		}
//	}
//	if (!loggedIn) {
//        System.out.println("Invalid PIN or password.");
//    }
// }
 
 //2nd refactor
//public boolean login(String username, String password) {
//	    for (User user : users.values()) {
//	        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//	            return true; // Login successful
//	        }
//	    }
//	    return false; // Login failed
//	}
 
 //1st refactor
// public boolean login(String username, String password) {
//	    for (User user : users.values()) {
//	        if (user != null && (user.password.equals(password) || user.pin.equals(password)) && user.username.equals(username)) {
//	            System.out.println("Login successful");
//	            return true; // Indicate success
//	        }
//	    }
//	    System.out.println("Invalid PIN or password.");
//	    return false; // Indicate failure
//}
 
 // Method to generate a random 6-digit string
 public static String generateSixDigitString() {
     Random random = new Random();
     StringBuilder sb = new StringBuilder();
     for (int i = 0; i < 6; i++) {
         sb.append(random.nextInt(10)); // Append a random digit (0-9)
     }
     return sb.toString();
 }
////Method to handle user login credentials
// public static void loginCredentials(ATM atm) {
//	 String userName;
//	 String password;
//	 Scanner userInput = new Scanner(System.in);
//	 System.out.println("Enter userName or 6 digit code");
//	 userName = userInput.nextLine();
//	 System.out.println("Enter password");
//	 password = userInput.nextLine();
//	 atm.login(userName,password);
//	 
// }
//Method to present user choices after login
 public static void userChoice() {
	 String input;
	 Scanner userInput = new Scanner(System.in);
	 
	 System.out.println("Checkings(c) \n Savings(s) \n");
	 input = userInput.nextLine();
	 
	
	 while (!input.equals("l")){
		 if(input.equals("c")) {
			 checkingsFunctionality(checkingAccount);// go to checkings functionality
		 }
		 else if (input.equals("s")) {
			 savingsFunctionality(savingAccount);// go to saving functionality
		 } 
		 System.out.println("\n Checkings(c) \n Savings(s) \n");
		 input = userInput.nextLine();
	 }
 }
 
 
 
 
//Utility method to add a new account to a JSON file
 public static void addAccountToJsonFile(String newAccountJson) {
     String jsonFilePath = "src/lab6/data.json";
     try {
         // Write the provided newAccountJson string to the file, overwriting existing content
         try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
             fileWriter.write(newAccountJson);
         }
         System.out.println("Account added to JSON file successfully.");
     } catch (IOException e) {
         System.err.println("Failed to update JSON file: " + e.getMessage());
     }
 }
 
 

 
// / Method to load utility company accounts from a JSON file
 public static void loadAccountsFromJsonFile(BankAccount userBankAccount) {
     // Define the path to your JSON file
     String jsonFilePath = "src/lab6/data.json";

     try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath))) {
         StringBuilder jsonData = new StringBuilder();
         String line;
         while ((line = reader.readLine()) != null) {
             jsonData.append(line);
         }
         
         // Convert StringBuilder to String
         String jsonString = jsonData.toString();
         
         // Define a pattern to match the "amountDue" value
         String pattern = "\"amountDue\": \"(\\d+(\\.\\d+)?)\"";
         
         double newAmount =  50 - userBankAccount.getBalance() ;
         if (newAmount < 0) {
        	 newAmount = 0 ;
        	 userBankAccount.withdraw(50);
         }
         else{
        	 newAmount = 50 - userBankAccount.getBalance();
        	 userBankAccount.withdraw(newAmount);
         }
         
         // Replace the "amountDue" value with the new value
         String modifiedJson = jsonString.replaceAll(pattern, "\"amountDue\": \"" + newAmount + "\"");
         System.out.println(modifiedJson);
         addAccountToJsonFile(modifiedJson);
         
         
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 
 
 public static void payBill(BankAccount userBankAccount){
	 loadAccountsFromJsonFile(userBankAccount);
 }
 
// Method to handle savings account operations
public static void savingsFunctionality(BankAccount userBankAccount) {
	String input;
	Scanner userInput = new Scanner(System.in);
	
	System.out.println("\n Savings account");
	System.out.println("Deposit(d)");
	System.out.println("Transfer(t)");
	System.out.println("Get balance(b)");
	
	input = userInput.nextLine();//get user input 
	
	switch(input) {
	case "d":
		String depositAmount;
		System.out.println("deposit \n");
		System.out.println("Deposit amount:");
		depositAmount = userInput.nextLine();
		userBankAccount.deposit(Integer.parseInt(depositAmount));// deposits money to savings account
		System.out.println(userBankAccount.getBalance());
		break;
	case "t":
		String transferAmount;
		System.out.println("transfer \n");
		System.out.println("Transfer to savings amount: ");
		transferAmount = userInput.nextLine();
		userBankAccount.transferToChecking(Integer.parseInt(transferAmount), checkingAccount); // transfer from savings to checkings
		break;
	case "b":
		System.out.println("get balance \n");
		System.out.println(userBankAccount.getBalance());
		break;
	default:
		System.out.println("Try again");
	}	
}
//Method to handle checkings account operations
public static void checkingsFunctionality(BankAccount userBankAccount) {
	String input;
	Scanner userInput = new Scanner(System.in);
	
	System.out.println("\n Checkings account");
	System.out.println("Deposit(d)");
	System.out.println("Withdraw(w)");
	System.out.println("Transfer(t)");
	System.out.println("Get balance(b)");
	System.out.println("Pay Bills(p)");
	
	input = userInput.nextLine();//get user input 
	switch(input) {
	case "d":
		String depositAmount;
		System.out.println("deposit \n");
		System.out.println("Deposit amount:");
		depositAmount = userInput.nextLine();
		userBankAccount.deposit(Integer.parseInt(depositAmount));// deposits money to checkings account
		System.out.println(userBankAccount.getBalance());
		break;
	case "w":
		String withDrawAmount;
		System.out.println("withdraw \n");
		System.out.println("Withdraw amount: ");
		withDrawAmount = userInput.nextLine();
		userBankAccount.withdraw(Integer.parseInt(withDrawAmount));
		System.out.println(userBankAccount.getBalance());
		break;
	case "t":
		String transferAmount;
		System.out.println("transfer \n");
		System.out.println("Transfer to savings amount: ");
		transferAmount = userInput.nextLine();
		userBankAccount.transferToSaving(Integer.parseInt(transferAmount), savingAccount);
		break;
	case "b":
		System.out.println("get balance \n");
		System.out.println(userBankAccount.getBalance());
		break;
	case "p":
		payBill(userBankAccount);
		System.out.println("bill payed");
	default:
		System.out.println("Try again");
	}
}
//Main method to run the ATM
 public static void main(String[] args) {
     ATM atm = new ATM();
     String userName;
     String password;
     String pin = generateSixDigitString();
     Scanner userInput = new Scanner(System.in);  // Create a Scanner object
     String sOrl;


     
     
     // while loop that runs forever here
     while(true){
	     userChoice();
     }
     
 }
}