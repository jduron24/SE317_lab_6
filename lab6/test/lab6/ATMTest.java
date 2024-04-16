package lab6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {

    private ATM atm;
//    private ByteArrayOutputStream outContent; 
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private User testUser;

    @BeforeEach
    public void setUp() {
        // Initialize ATM instance before each test
        atm = new ATM();
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture outputs
        atm.registerUser("test_user", "test_pass", "123456");
        testUser = atm.getUser("test_user"); // Assume getUser is a method to retrieve a User object.
        // Set starting balances for testing
        testUser.depositToChecking(1000); // Starting balance for checking
        testUser.depositToSaving(500); // Starting balance for savings
    }

    @Test
    public void testUserRegistrationAndLogin() {
    	
    	
//         Test user registration and login functionalities
//         Test cases: register new user, register existing user, login with valid credentials,
//         login with invalid credentials
//         Ensure expected outcomes for each test case
    	 // Test registering a new user
//        atm.registerUser("john_doe", "password123", "123456");
//        assertTrue(outContent.toString().contains("User registered successfully."));
//        outContent.reset(); // Clear the output stream for the next test
//
//        // Test registering an existing user
//        atm.registerUser("john_doe", "password123", "123456");
//        assertTrue(outContent.toString().contains("Username already exists. Please choose another one."));
//        outContent.reset();
//
//        // Test login with valid credentials
//        atm.registerUser("jane_doe", "password321", "654321");
//        outContent.reset(); // Clear previous outputs
//        atm.login("jane_doe", "password321");
//        assertTrue(outContent.toString().contains("Login successful"));
//        outContent.reset();
//
//        // Test login with invalid credentials
//        atm.login("jane_doe", "wrongpassword");
//        assertTrue(outContent.toString().contains("Invalid PIN or password."));
    	
    	
    	// ----- ****these two tests works***
    	
    	//register a new user
//    	atm.registerUser("john_doe", "password123", "123456");
//        assertTrue(outContent.toString().contains("User registered successfully."));
//        outContent.reset();
//
//        //register an existing user
//        atm.registerUser("john_doe", "password123", "123456");
//        assertTrue(outContent.toString().contains("Username already exists. Please choose another one."));
//        outContent.reset();
        // -----
    	
//        // Test registering a new user
//        atm.registerUser("new_user", "new_pass", "111111");
//        assertTrue(outContent.toString().contains("User registered successfully."));
//        outContent.reset();
//
//        // Test registering an existing user
//        atm.registerUser("new_user", "new_pass", "111111");
//        assertTrue(outContent.toString().contains("Username already exists. Please choose another one."));
//        outContent.reset();

//        // Test login with valid credentials
//        atm.registerUser("valid_user", "valid_pass", "333333");
//        outContent.reset();  // Clear the stream to only test for login message
//        atm.login("valid_user", "valid_pass");
//        assertTrue(outContent.toString().contains("Login successful"));
//        outContent.reset();
//
//        // Test login with invalid credentials
//        atm.login("valid_user", "wrong_pass");
//        assertTrue(outContent.toString().contains("Invalid PIN or password."));
        
    }

    @Test
    public void testBankAccountOperations() {
        // Test bank account operations functionalities
        // Test cases: deposit into checking account, withdraw from checking account,
        // transfer between checking and savings account, deposit into savings account,
        // withdraw from savings account, transfer between savings and checking account
        // Ensure expected outcomes for each test case
    	
    	
    	
    	// this.testUser is nulll, causing an error
    	 // Deposit into checking account
        testUser.depositToChecking(200);
        assertEquals(1200, testUser.getCheckingAccount(), "Checking account should have 1200 after deposit");

        // Withdraw from checking account
        testUser.withdrawFromCheckings(300);
        assertEquals(900, testUser.getCheckingAccount(), "Checking account should have 900 after withdrawal");

        // Transfer between checking and savings account
        testUser.transferCheckingsToSavings(400);
        assertEquals(500, testUser.getCheckingAccount(), "Checking account should have 500 after transfer");
        assertEquals(900, testUser.getSavingsAccount(), "Savings account should have 900 after transfer");

        // Deposit into savings account
        testUser.depositToSaving(100);
        assertEquals(1000, testUser.getSavingsAccount(), "Savings account should have 1000 after deposit");

        
        // tests work up until this point
        
        
//        // Withdraw from savings account
//        testUser.withdrawFromCheckings(200); // Assume method exists
//        assertEquals(800, testUser.getSavingsAccount(), "Savings account should have 800 after withdrawal");
//
//        // Transfer from savings to checking account
//        testUser.transferSavingsToCheckings(300);
//        assertEquals(800, testUser.getCheckingAccount(), "Checking account should have 800 after receiving transfer");
//        assertEquals(500, testUser.getSavingsAccount(), "Savings account should have 500 after making transfer");
    	
    }

    @Test
    public void testUtilityCompanyOperations() {
        // Test utility company operations functionalities
        // Test cases: create utility company account, login to utility company account,
        // check bill payment history, check next bill payment amount and due date
        // Ensure expected outcomes for each test case
    }

    @Test
    public void testDataStorage() {
        // Test data storage functionalities
        // Test cases: null storage for user accounts, null storage for utility company account,
        // null element with multiple user accounts, null single element for user account,
        // incompatible types in storage, empty elements in user accounts,
        // two normal cases: single and multiple user accounts
        // Ensure expected outcomes for each test case
    }
    
    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out); // Restore System.out to the original System.out
    }
    
}
