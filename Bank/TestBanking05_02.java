package com.vzard.javase.Bank;

public class TestBanking05_02 {
	
	
	public static void main(String[] args) {
		Bank bank =Bank.getgetBank();
		Customer customer;
		CustomerReport customerReport = new CustomerReport();
		
		bank.addCustomer("Simms","Jane");
		customer = bank.getCustomer(0); // first customer
		customer.setSaving(new SavingAccount(500,0));
		customer.setChecking(new CheckingAccount(200,customer.getSaving()));
		
		System.out.println("Customer ["+customer.getFirstName()+" "+customer.getLastName()+" ] has a checking balance of "+customer.getChecking().balance+" and a saving balance of "+customer.getSaving().balance);
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] : withdraw 150.00 succeeds? "+customer.checking.withdraw(150.00));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] : deposit 22.50 succeeds? "+customer.checking.deposit(22.50));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] : withdraw 147.62 succeeds? "+customer.checking.withdraw(147.62));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+"] has a checking balance of "+customer.getChecking().balance+" and savings balance of "+customer.getSaving().balance);
		
		System.out.println();
		
		bank.addCustomer("Owen","Bryant");
		customer = bank.getCustomer(1);  //√ª”–saving’Àªß
		customer.setChecking(new CheckingAccount(200));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] : withdraw 10.00 succeeds? "+customer.checking.withdraw(100.00));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] : deposit 25.00 succeeds? "+customer.checking.deposit(25.00));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] : withdraw 175.00 succeeds? "+customer.checking.withdraw(175.00));
		System.out.println("Checking Acct ["+customer.getFirstName()+" "+customer.getLastName()+" ] has a checking balance of "+customer.getChecking().balance);
	}

}
