package lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setUp() {
        // Initialize ATM instance before each test
        atm = new ATM();
    }

    @Test
    public void testUserRegistrationAndLogin() {
        // Test user registration and login functionalities
        // Test cases: register new user, register existing user, login with valid credentials,
        // login with invalid credentials
        // Ensure expected outcomes for each test case
    }

    @Test
    public void testBankAccountOperations() {
        // Test bank account operations functionalities
        // Test cases: deposit into checking account, withdraw from checking account,
        // transfer between checking and savings account, deposit into savings account,
        // withdraw from savings account, transfer between savings and checking account
        // Ensure expected outcomes for each test case
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
}
