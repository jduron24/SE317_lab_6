package lab6;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UtilityCompany {
	private Map<String, UtilityAccountInfo> accounts;


    public UtilityCompany() {
        // Initialize utility company accounts
        this.accounts = new HashMap<>();
    }

    // Method to create a new utility company account
    public void createAccount(String username, String password, String pin) {
    	UtilityAccountInfo accountInfo = new UtilityAccountInfo(username, password, pin);
        accounts.put(username, accountInfo);
        System.out.println("Utility company account created successfully.");
    }
    // Method to login to the utility company account
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Utility Company Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        
        boolean loggedIn = false;
    	for(UtilityAccountInfo user : accounts.values()) {
    		if (user != null && (user.getUsername().equals(username) || user.getPin().equals(password)) && user.getPassword().equals(password)) {
    	        System.out.println("Login successful");
//    	        userChoice(user);
    	        loggedIn = true;
    	        break;
    		}
    	}
    	if (!loggedIn) {
            System.out.println("Invalid PIN or password.");
        }
        
//        if (accounts.containsKey(username) && accounts.get(password).equals(password)) {
//            System.out.println("Login successful.");
//            return true;
//        } else {
//            System.out.println("Invalid username or password.");
//            return false;
//        }
    }
 
    
    public static String generateSixDigitString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	 String userName;
         String password;
         String pin = generateSixDigitString();
         UtilityCompany utilityCompany = new UtilityCompany();
         Scanner userInput = new Scanner(System.in);  // Create a Scanner object
         String sOrl;
        
        

        
        
        System.out.println("Create a new account Enter user name: ");
        userName = userInput.nextLine();
    
        System.out.println("Enter a password");
        password = userInput.nextLine();
        
        System.out.println("Your unique pin #: " + pin); 
        utilityCompany.createAccount(userName, password, pin);
        
        // while loop that runs forever here
        while(true){
   	     System.out.println("Sign-up(s) or login(l)");
   	     sOrl = userInput.nextLine();
   	     
   	     if(sOrl.equals("l")) {
   	        utilityCompany.login();// Prompt user to login
   	     }
   	     else if(sOrl.equals("s")) {
   	    	 //Sign up functionality here 
   	    	 System.out.println("Create a new account Enter user name: ");
   	         userName = userInput.nextLine();
   	     
   	         System.out.println("Enter a password");
   	         password = userInput.nextLine();
   	         
   	         System.out.println("Your unique pin #: " + pin);
   	         
   	         utilityCompany.createAccount("utilityUser", "password", pin);
   	         
   	     }
        }
    }
}

