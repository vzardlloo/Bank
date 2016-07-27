package com.vzard.javase.Bank;

import org.junit.Test;
 
public class CustomerReport {
	//@Test
	public void generateReport(){
		
		Bank bank = Bank.getgetBank();
		Customer customer = null;
		
		System.out.println("\t\t\t CUSTOMER REPORT");
		System.out.println("\t\t\t===================");
		System.out.println("客户数量："+bank.numberOfCustomers);
		
		for(int cust_idx = 0;cust_idx <bank.getNumOfCustomers();cust_idx++){
			customer = bank.getCustomer(cust_idx);
			
			System.out.println();
			System.out.println("Customer: [ "+ customer.getLastName()+" "+customer.getFirstName()+" ]"+" 拥有账户数量："+customer.NumOfAccount);
			
			for (int acct_idx = 0;acct_idx<customer.getNumOfAccounts();acct_idx++){
				Account account = customer.getAccount(acct_idx);
				String account_type = "";
				
				/**
				 *Step 1: Use the instanceof operator to test what type of
				 * account we have and set account_type to an appropriate value,
				 * such as "Savings Account" or "Checking Account". 
				 */
				if(account instanceof CheckingAccount){
					account_type =  "CheckingAccount";
					
				}else if(account instanceof SavingAccount){
					account_type = "SavingAccout";
				}
				//Print the current balance of the account 
				/**
				 * Step 2: Print out the type of account and the balance. Feel
				 * free to use the currency_format formatter to generate a
				 * "currency string" for the balance.
				 */
				
				System.out.println(account_type+": current balance is $"+account.getBalance());
			}
		}
 }
}
