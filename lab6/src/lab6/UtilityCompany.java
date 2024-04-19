package lab6;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class UtilityCompany {
	private static Map<String, UtilityAccountInfo> accounts;

    public UtilityCompany() {
        // Initialize utility company accounts
        this.accounts = new HashMap<>();
        
    }

    // Method to load utility company accounts from a JSON file
    public static void loadAccountsFromJsonFile() {
    	
    	 // Define the path to your JSON file
        String jsonFilePath = "src/lab6/data.json";
        
    	
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath))) {
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }

            // Parse the JSON data manually
            List<UtilityAccountInfo> accountInfoList = parseJsonData(jsonData.toString());

//            // Print the parsed data
//            for (UtilityAccountInfo accountInfo : accountInfoList) {
//                System.out.println("Username: " + accountInfo.getUsername());
//                System.out.println("Password: " + accountInfo.getPassword());
//                System.out.println("PIN: " + accountInfo.getPin());
//                System.out.println();
            
         // Add each UtilityAccountInfo object to the accounts map
            for (UtilityAccountInfo accountInfo : accountInfoList) {
                accounts.put(accountInfo.getUsername(), accountInfo);
            }
//                
//            }
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
    // Method to manually parse the JSON data
    private static List<UtilityAccountInfo> parseJsonData(String jsonData) {
    	 List<UtilityAccountInfo> accountInfoList = new ArrayList<>();

         // Remove leading and trailing brackets [ and ]
         jsonData = jsonData.substring(1, jsonData.length() - 1);
         
         // Split JSON data by commas to separate individual objects         
//         String[] keyValuePairs = jsonData.split(",");

      // Split JSON string by }, to separate individual objects
         String[] jsonObjects = jsonData.split("\\},\\s*");
         
         String username = null;
         String password = null;
         String pin = null;
         
         // Iterate over each object
         for (String pair : jsonObjects) {
        	 // Split the JSON string by comma to separate key-value pairs
             String[] keyValuePairs = pair.split(",\\s*");

             // Iterate over each key-value pair
             for (String pair2 : keyValuePairs) {
                 // Split the key-value pair by colon to separate key and value
                 String[] keyValue = pair2.split(":\\s*");

                 // Extract key and value
                 String key = keyValue[0].replaceAll("\"", "").trim();
                 String value = keyValue[1].replaceAll("\"", "").trim();

               
                 if (key.contains("username")) {
                     username = value;
                 } else if (key.equals("password")) {
                     password = value;                 
                 } else if (key.equals("pin")) {
                     pin = value;
                 }
             }    
             UtilityAccountInfo accountInfo = new UtilityAccountInfo(username, password, pin);
             accountInfoList.add(accountInfo);
             
         }
         
         return accountInfoList;
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
    	        
    	        UtilityUserChoice();
    	        loggedIn = true;
    	        break;
    		}
    	}
    	if (!loggedIn) {
            System.out.println("Invalid PIN or password.");
        }
        
    }
 
    
    public static String generateSixDigitString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }
    
    
    public void UtilityUserChoice() {
    	String input;
    	Scanner userInput = new Scanner(System.in);  // Create a Scanner object
    	String payAmount = "50";
    	String paymentHistory;
    	System.out.println("Payment History (p)");
    	System.out.println("Next Bill Payment(b)");
    	
    	paymentHistory = "3/18/2024, 2/18/2024, 1/18/2024";
    	input = userInput.nextLine();
    	
    	if(input.equals("p")) {
    		System.out.println(paymentHistory);
    	}
    	else if(input.equals("b")) {
    		System.out.println("Amount due "+payAmount +" Due Date 25th");
    	}
    }

    public static void main(String[] args) {
    	 String userName;
         String password;
         String pin = generateSixDigitString();
         UtilityCompany utilityCompany = new UtilityCompany();
         Scanner userInput = new Scanner(System.in);  // Create a Scanner object
         String sOrl;
        
        
         
         loadAccountsFromJsonFile(); // Load accounts from JSON file
        
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

