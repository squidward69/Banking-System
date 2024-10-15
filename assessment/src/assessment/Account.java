package assessment;

public class Account extends Customer{
	private int balance;
	private int accountNumber;

	//constructor
	public Account(String FName, String LName,int accountNumber,int balance) {
		//set first name and lastname using method from customer class
		setFirstName(FName);
		setLastName(LName);
		//set balance and accountNumber
		
		this.accountNumber=accountNumber;
		this.balance= balance;
	}

	// getter method for balance and account number
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public long getBalance() {
		return balance;
	}
	

	public void deposit(int amount){
		balance+=amount;
	}
	
	public void withdraw(int amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.println("Withdrawal of " + amount + " successful.");
		}else {
			System.out.println("Insufficient funds. Withdrawal failed.");
		}
	
	}
	
	 // Override toString() method
    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
               ", Name: " + getFirstName() + " " + getLastName() +
               ", Balance: $" + balance;
    }
	
}
