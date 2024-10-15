package assessment;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.Font;
import java.awt.Color;

public class GUI extends JFrame {
    // Global Variables
    private LinkedList<Account> globalAccounts;
    private StringBuilder sbAllData;
    
    // GUI Components
    private JLabel showAllData;
    private JButton showAllButton, depositButton, withdrawButton, transferButton;
    private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer, depositInput, withdrawInput, transferAmount;

    public GUI(LinkedList<Account> accounts) {
        // Set up the frame
        super("Banking System");
        getContentPane().setBackground(new Color(192, 192, 192));
        getContentPane().setLayout(null);

        // Initialize global variables
        globalAccounts = accounts;
        sbAllData = new StringBuilder();

        // Populate sbAllData with account information
        for (Account account : globalAccounts) {
            sbAllData.append(account.toString()).append("\n");
        }

        // Initialize Components
        showAllData = new JLabel();
        showAllData.setBackground(new Color(255, 255, 255));
        showAllData.setFont(new Font("Tahoma", Font.PLAIN, 16));
        showAllButton = new JButton("Show All");
        showAllButton.setBackground(new Color(255, 0, 128));
        showAllButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        depositButton = new JButton("Deposit");
        depositButton.setBackground(new Color(255, 128, 64));
        depositButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(255, 128, 64));
        withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        transferButton = new JButton("Transfer");
        transferButton.setBackground(new Color(255, 128, 64));
        transferButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        accDeposit = new JTextField("Account # for Deposit");
        accWithdraw = new JTextField("Account # for Withdraw");
        acc1Transfer = new JTextField("Account #1 for Transfer From");
        acc2Transfer = new JTextField("Account #2 for Transfer To");
        depositInput = new JTextField("Deposit Amount");
        withdrawInput = new JTextField("Withdraw Amount");
        transferAmount = new JTextField("Transfer Amount");
        transferAmount.setBackground(new Color(255, 255, 255));

        // Set bounds for each component
        showAllButton.setBounds(50, 50, 150, 30);
        showAllData.setBounds(50, 100, 796, 229);

        accDeposit.setBounds(50, 375, 200, 30);
        depositInput.setBounds(260, 375, 150, 30);
        depositButton.setBounds(420, 374, 100, 30);

        accWithdraw.setBounds(50, 450, 200, 30);
        withdrawInput.setBounds(260, 450, 150, 30);
        withdrawButton.setBounds(420, 450, 100, 30);

        acc1Transfer.setBounds(50, 526, 200, 30);
        acc2Transfer.setBounds(262, 526, 200, 30);
        transferAmount.setBounds(473, 526, 150, 30);
        transferButton.setBounds(633, 525, 100, 30);

        // Add components to the frame
        getContentPane().add(showAllButton);
        getContentPane().add(showAllData);
        getContentPane().add(accDeposit);
        getContentPane().add(depositInput);
        getContentPane().add(depositButton);
        getContentPane().add(accWithdraw);
        getContentPane().add(withdrawInput);
        getContentPane().add(withdrawButton);
        getContentPane().add(acc1Transfer);
        getContentPane().add(acc2Transfer);
        getContentPane().add(transferAmount);
        getContentPane().add(transferButton);
        
        JTextPane txtpnDeposit = new JTextPane();
        txtpnDeposit.setBackground(new Color(255, 128, 128));
        txtpnDeposit.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnDeposit.setText("Deposit");
        txtpnDeposit.setBounds(50, 339, 100, 26);
        getContentPane().add(txtpnDeposit);
        
        JTextPane txtpnWithdraw = new JTextPane();
        txtpnWithdraw.setBackground(new Color(255, 128, 128));
        txtpnWithdraw.setText("Withdraw");
        txtpnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnWithdraw.setBounds(50, 415, 100, 26);
        getContentPane().add(txtpnWithdraw);
        
        JTextPane txtpnT = new JTextPane();
        txtpnT.setBackground(new Color(255, 128, 128));
        txtpnT.setText("Transfer");
        txtpnT.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtpnT.setBounds(50, 490, 100, 26);
        getContentPane().add(txtpnT);

        // Set up action listeners
        HandlerClass handler = new HandlerClass();
        showAllButton.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);
    }

    // Handler class to manage button actions
    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showAllButton) {
            	//display all account data
            	 updateAllDataDisplay();
//                showAllData.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
            } else if (e.getSource() == depositButton) {
            	//handle deposit
                int accNumber = Integer.parseInt(accDeposit.getText()); // Changed to int
                int amount = Integer.parseInt(depositInput.getText()); // Changed to int
                
                for (Account account : globalAccounts) {
                    if (account.getAccountNumber() == accNumber) { 
                        account.deposit(amount);
                        JOptionPane.showMessageDialog(null, "Deposit successful!");
                        updateAllDataDisplay(); // Update the display after the deposit
                        updateCSVFile(); // Update CSV after deposit
                        break; //exit loop once account is found
                    }
                }
            } else if (e.getSource() == withdrawButton) {
            	//handle withdraw
            	 int accNumber = Integer.parseInt(accWithdraw.getText()); // Changed to int
                 int amount = Integer.parseInt(withdrawInput.getText()); // Changed to int
                 
                for (Account account : globalAccounts) {
                    if (account.getAccountNumber() == accNumber) {
                        account.withdraw(amount);
                        JOptionPane.showMessageDialog(null, "Withdrawal successful!");
                        updateAllDataDisplay(); // Update the display after the withdrawal
                        updateCSVFile(); // Update CSV after withdrawl
                        break; //exit loop once account is found
                    }
                }
            } else if (e.getSource() == transferButton) {
            	//handle transfer
            	int acc1 = Integer.parseInt(acc1Transfer.getText()); 
                int acc2 = Integer.parseInt(acc2Transfer.getText()); 
                int amount = Integer.parseInt(transferAmount.getText()); 
                
                Account fromAccount = null, toAccount = null;

                for (Account account : globalAccounts) {
                    if (account.getAccountNumber()==acc1) {
                        fromAccount = account;
                    } else if (account.getAccountNumber()==acc2) {
                        toAccount = account;
                    }
                }

                if (fromAccount != null && toAccount != null) {
                    if (fromAccount.getBalance() >= amount) { // Ensure sufficient balance
                        fromAccount.withdraw(amount);
                        toAccount.deposit(amount);
                        JOptionPane.showMessageDialog(null, "Transfer successful!");
                        updateAllDataDisplay(); // Update the display after the transfer
                        updateCSVFile(); // Update CSV after transfer
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid account numbers!");
                }
                
            }
        }

        private void updateCSVFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.csv"))) {
                for (Account account : globalAccounts) {
                    writer.write(account.getFirstName() + "," + account.getLastName() + "," + account.getAccountNumber() + "," + account.getBalance());
                    writer.newLine();
                }
                System.out.println("CSV file updated successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to update CSV file.");
            }
        }
		private void updateAllDataDisplay() {
            sbAllData.setLength(0); // Clear existing data
            for (Account account : globalAccounts) {
                sbAllData.append(account.toString()).append("\n");
            }
            showAllData.setText("<html>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
        }
    }
}





