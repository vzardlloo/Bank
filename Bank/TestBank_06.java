package com.vzard.javase.Bank;

public class TestBank_06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bank bank = Bank.getgetBank();
		Customer customer;
		CustomerReport report = new CustomerReport();
		
		bank.addCustomer("Jane","Simms");
		customer = bank.getCustomer(0); //first customer
		customer.addAccount(new SavingAccount(500.00,0.05));
		customer.addAccount(new CheckingAccount(200,400));
		
		bank.addCustomer("Owen","Bryant");
		customer = bank.getCustomer(1); // second customer
		customer.addAccount(new SavingAccount(500.00,0.05));
		customer.addAccount(new CheckingAccount(200.00,customer.getSaving()));
		
		bank.addCustomer("Tim","Soley");
		customer = bank.getCustomer(2); //third customer
		customer.setSaving(new SavingAccount(1500.00,0.05));
		customer.setChecking(new CheckingAccount(200));
		
		bank.addCustomer("Maria","Soley");
		customer = bank.getCustomer(3); //fourth customer
		customer.addAccount(new SavingAccount(150.00,0.05));
		customer.addAccount(bank.getCustomer(2).getChecking());
		
		
		//Generate a report
		report.generateReport();
	}

}
