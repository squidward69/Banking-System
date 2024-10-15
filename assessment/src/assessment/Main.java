package assessment;

import java.util.LinkedList;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
//		//part1
//		//create account1
//		Account account1= new Account("Jeffrey", "Ting", 1,2000);
//		
//		//create account2
//		Account account2= new Account("Hiran","Patel", 2,1000 );
//		
//		//print out balance of account1 and account2
//		System.out.println("Account 1 Balance: "+ account1.getBalance());
//		
//		System.out.println("Account 2 Balance: "+ account2.getBalance());
//		
//		//deposit 250 to account1
//		account1.deposit(250);
//		System.out.println("Account 1 balance after deposit: "+ account1.getBalance());
//		
//		//withdraw 500 from account2
//		account2.withdraw(500);
//		System.out.println("Account2 balance after withdraw: "+ account2.getBalance());
//		
//		//create a transaction object
//		Transaction t= new Transaction();
//		
//		//transfer 250 from account1 to account2
//		t.transfer(account1, account2, 250);
//		
//		//Print out balance of account1 after transfer
//		System.out.println("Account 1 Balance after transfer: "+account1.getBalance());
//		
//		// Print out balance of account2 after transfer
//		System.out.println("Account 2 Balance after transfer: "+account2.getBalance());
		
		
		
//		
//		//part2
//		
		//create read accounts object
		ReadAccounts readAccounts = new ReadAccounts("accounts.csv");
		
		LinkedList<String> firstNames= readAccounts.getFirstNames();
		LinkedList<String> lastNames= readAccounts.getLastNames();
		LinkedList<Integer>  accountList = readAccounts.getAccounts();
		LinkedList<Integer>  balanceList = readAccounts.getBalances();
	
		//create linkedlist of accounts 
		LinkedList<Account> accounts = new LinkedList<>();

		//populate account list using data from csv
		for(int i =0; i<firstNames.size(); i++) {
			accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
			
		}
		
		
		//testing the accounts
//		Account account1= accounts.get(0);
//		Account account2= accounts.get(1);
//		Account account3= accounts.get(2);
//		Account account4= accounts.get(3);
//		
//		
//		System.out.println("Initial Balances:");
//		System.out.println(account1.getFirstName() + " " + account1.getLastName() + ": " + account1.getBalance());
//		System.out.println(account2.getFirstName() + " " + account2.getLastName() + ": " + account2.getBalance());
//		System.out.println(account3.getFirstName() + " " + account3.getLastName() + ": " + account3.getBalance());
//		System.out.println(account4.getFirstName() + " " + account4.getLastName() + ": " + account4.getBalance());
//		
//		//withdraw from account2
//		
//		System.out.println();
//		account2.withdraw(200);
//		System.out.println(account2.getFirstName()+" "+ account2.getLastName()+ ": " + account2.getBalance());
//		
//		
//		//deposit into account1
//		account1.deposit(250);
//		System.out.println();
//		System.out.println("Balance after deposit");
//		System.out.println(account1.getFirstName()+" "+ account1.getLastName()+ ": " + account1.getBalance());
//
//		//withdraw from account3
//		System.out.println();
//		account3.withdraw(10000);
//		System.out.println("Balance after wiithdrawl");
//		System.out.println(account3.getFirstName()+" "+ account3.getLastName()+ ": " + account3.getBalance());
//		
//		//transfer money from account4 to acount2
//		System.out.println();
//		Transaction t = new Transaction();
//		t.transfer(account4, account2, 20000);
//		System.out.println();
//		System.out.println("Balance after transfer");
//		System.out.println(account2.getFirstName()+" "+ account2.getLastName()+ ": " + account2.getBalance());
//		
		
		//part3
	        GUI gui = new GUI(accounts);
	        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        gui.setSize(800, 600);
	        gui.setVisible(true);
		

		
		
	}

}
