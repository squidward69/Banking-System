package assessment;

public class Transaction {
	
	 public void transfer(Account source, Account destination, int amount){
		 //withdraw amount form source account
		 source.withdraw(amount);
		 
		 //deposit amount to destination account 
		 destination.deposit(amount);
		 
		
	}
	

}
