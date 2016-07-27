package com.vzard.javase.Bank;
/*
 * this class creates the program to test the banking classes.
 * it creates a set of customers,with a few accounts each,
 * and generates a report of current account balances.
 */
public class TestBanking05 {
public static void main(String[] args){
	Bank bank = Bank.getgetBank();
	Customer customer;
	
	//Create several customers and their accounts
	bank.addCustomer("Jane","Simms");
	customer = bank.getCustomer(0);
	customer.addAccount(new SavingAccount(500.00,0.05));
	customer.addAccount(new CheckingAccount(200.00,400.00));
	
	bank.addCustomer("Owen","Bryant");
	customer = bank.getCustomer(1);
	customer.addAccount(new CheckingAccount(200.00));
	
	bank.addCustomer("Tim","Soley");
	customer = bank.getCustomer(2);
	customer.addAccount(new SavingAccount(1500.00,0.05));
	customer.addAccount(new CheckingAccount(200.00));
	
	bank.addCustomer("Maria","Soley");
	customer = bank.getCustomer(3);
	customer.addAccount(bank.getCustomer(2).getAccount(1));
	customer.addAccount(new SavingAccount(150.00,0.05));
	
	//Generate a report
	System.out.println("\t\t\tCUSTOMERS REPORT");
	System.out.println("\t\t\t================");
	System.out.println("客户数量： "+bank.getNumOfCustomers());
	for(int cust_idx = 0;cust_idx < bank.getNumOfCustomers();cust_idx++){
		customer = bank.getCustomer(cust_idx);
		System.out.println();
		System.out.println("Customer: "+customer.getLastName()+", "+customer.getFirstName()+"  拥有账户数量： "+customer.getNumOfAccounts());
		for(int acct_idx = 0;acct_idx < customer.getNumOfAccounts();acct_idx++){  
			Account account = customer.getAccount(acct_idx);
			String account_type = "";
			
			//Determine the account type
			/**
			 * Step 1:Use the instanceof operator to test what type of
			 * account we have and set accout_type to an appropriate value
			 * such as "Savings Account" or "Checking Account".
			 */
			
			if (account instanceof SavingAccount) {
				account_type = "Savings Accout";
				
			}else if(account instanceof CheckingAccount){
				account_type = "Cheaking Account";
			}
			/*
			 * Print the current balance of the account
			 * Step:print out the type of account and balance.
			 * free to use the currency_format formatter to generate a
			 * "currency string" for the balance.
			 */
			System.out.println(account_type + ": current balance is $"+account.getBalance());
		}
	}
	
	
  }
}
