package com.vzard.javase.Bank;

public class TestBank_07 {

	
	public static void main(String[] args) {
		Bank bank = Bank.getgetBank();
		Customer customer;
		Account account;
		bank.addCustomer("Simms","Jane");
		customer = bank.getCustomer(0);  //first customer
		customer.setChecking(new CheckingAccount(200.00,500.00));
		customer.setSaving(new SavingAccount(500.00,0.05));
		bank.addCustomer("Owen","Bryant");
		customer = bank.getCustomer(1);
		customer.addAccount(new CheckingAccount(200.00));
		
		//Test the checking of Jane Simms (with overdaft protection)
		customer = bank.getCustomer(0);
		account = customer.getChecking();
		System.out.println("Customer ["+ customer.getLastName()+","+customer.getFirstName()+"]"+" has a checking balance of"+account.getBalance()
				            +" with a 500.00 overdraft protection");
		try{
			System.out.println("Checking Acct [Jane Simms]: withdraw 150.00");
			account.withdraw(150.00);
			System.out.println("Checking Acct [Jane Simms]: deposit 22.50");
			account.deposit(22.50);
			System.out.println("Checking Acct [Jane Simms]: withdraw 470.00");
			account.withdraw(670.00);
			
		}catch(OverDraftException e1){
			System.out.println("Excption: "+e1.getMessage()+" Deficit: "+e1.getDeficit());
			
		}finally{
			System.out.println("Customer ["+customer.getLastName()
								+","+customer.getFirstName()+"]"
								+"has a checking balance of "
								+account.getBalance());
		}
		System.out.println();
		
		//Test the checking account of Owen Bryant (without overdraft protection)
		customer = bank.getCustomer(1);
		account = customer.getAccount(0);
		System.out.println("Customer ["+customer.getLastName()+","+customer.getFirstName()
										+" has a checking balance of "
										+account.getBalance());
		try{
			System.out.println("Checkiing Acct [Owen Bryant]: withdraw 100.00");
			account.withdraw(100.00);
			System.out.println("Checking Acct [Owen Bryant]: deposit 25.00");
			account.deposit(25.00);
			System.out.println("Checking Acct [Owen Bryant]: withdraw 175.00");
			account.withdraw(175.00);
		}catch(OverDraftException e2){
			System.out.println("Exception: "+e2.getMessage()+","+"  Deficit:"+e2.getDeficit());
			
		}finally{
			System.out.println("Customer ["+customer.getLastName()+","+customer.getFirstName()+"]"
										    +" has a checkiing balance of "+account.getBalance());
		}
	}

}
