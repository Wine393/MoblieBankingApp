package BankAccountDemo;

	public class UseageExample {
	    public static void main(String[] args) {
	        // Create account
	        BankAccount account = new BankAccount("123456789", "John Doe", 1000, "secure@123");
	        
	        // Access data via controlled methods
	        System.out.println("Account Holder: " + account.getAccountHolderName());
	        
	        // Valid operations
	        account.deposit(500);
	        account.withdraw(200, "secure@123");
	        account.setAccountHolderName("Jane Doe");
	        account.changePassword("secure@123", "new@456");
	        
	        // Attempt invalid operations
	        account.withdraw(2000, "wrongPassword"); // Auth fail
	        account.deposit(-100);                  // Invalid amount
	        account.getBalance("invalid");           // Auth fail
	    }
	}