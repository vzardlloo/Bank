package com.vzard.javase.Bank;

public class TestBanking {
public static void main(String[] args ){
  Account account;
  Customer customer;
  Bank bank = new Bank();  //实例化了一个bank,即创立了一个可以包含10个custom的bank
  
  System.out.println("Creating the customer Jane Smith.");
  bank.addCustomer("smith","Jane"); // 第一个custom
  System.out.println("Creating her Savings Account with a 500.00 balance and 3% interest.");
  customer = bank.getCustomer(0);
  customer.addAccount(new SavingAccount(500,0.03));
  
  System.out.println("Creating the customer Owen Bryant.");
  bank.addCustomer("Bryant","Owen"); //第二个custom
  System.out.println("Creating  his  Checking  Account  with  a  500.00  balance  and  no overdraft protection");
  customer = bank.getCustomer(1);
  customer.addAccount(new CheckingAccount(500,0));
  
  System.out.println("Creating the customer Tim Soley.");
  bank.addCustomer("Soley", "Tim");  //第三个custom
  System.out.println("Creating  his  Checking  Account  with  a 500.00  balance  and 500.00 in overdraft protection.");
  customer = bank.getCustomer(2);
  customer.addAccount(new CheckingAccount(500,500));
  
  System.out.println("Creating the customer Maria Soley.");
  bank.addCustomer("Soley","Maria"); //第四个custom
  System.out.println("Maria shares her Checking Account with her husband Tim.");
  customer = bank.getCustomer(3);
  customer.addAccount(bank.getCustomer(2).getAccount(1));
  
  System.out.println();
  
  System.out.println("Retrieving the customer Jane Smith with her savings account.");
  account = bank.getCustomer(0).getAccount(0);
  System.out.println("With 150.00: "+account.withdraw(150.00));
  System.out.println("Deposit 22.50: "+account.deposit(22.50));
  System.out.println("Withdraw 47.62： "+account.withdraw(47.62));
  System.out.println("Withdraw 400.00: "+account.withdraw(400.00));
  System.out.println("Customer ["+bank.getCustomer(0).getLastName()+" "+bank.getCustomer(0).getFirstName()+"] has a balance of "+bank.getCustomer(0).getAccount(0).getBalance());
  
  System.out.println();
  
  System.out.println("Retrieving the customer Owen Bryant with his checking account with no overdraft protection.");
  account = bank.getCustomer(1).getAccount(0);
  System.out.println("Withdraw 150.00: "+account.withdraw(150.00));
  System.out.println("Deposite 22.50: "+account.deposit(22.50));
  System.out.println("Withdraw 47.62: "+account.withdraw(47.62));
  System.out.println("Withdraw 400.00: "+account.withdraw(400.00));
  System.out.println("Customer ["+bank.getCustomer(1).getLastName()+" "+bank.getCustomer(1).getFirstName()+"] has a balance of "+bank.getCustomer(1).getAccount(0).getBalance());
  
  System.out.println();
  
  System.out.println("Retrieving the customer Tim Soley with his checking account with 500 overdraft protection.");
  account = bank.getCustomer(2).getAccount(0);
  System.out.println("Withdraw 150.00: "+account.withdraw(150.00));
  System.out.println("Deposite 22.50: "+account.deposit(22.50));
  System.out.println("Withdraw 47.62: "+account.withdraw(47.62));
  System.out.println("Withdraw 400.00: "+account.withdraw(400.00));
  System.out.println("Customer ["+bank.getCustomer(2).getLastName()+" "+bank.getCustomer(2).getFirstName()+"] has a balance of "+bank.getCustomer(2).getAccount(0).getBalance());
  
  System.out.println();
  
  System.out.println("Retrieving the customer Soley Maria with his checking account with no overdraft protection.");
  account = bank.getCustomer(2).getAccount(0);
  //System.out.println("Withdraw 150.00: "+account.withdraw(150.00));
  System.out.println("Deposite 150.00: "+account.deposit(150.00));
  //System.out.println("Withdraw 47.62: "+account.withdraw(47.62));
  System.out.println("Withdraw 750.00: "+account.withdraw(750.00));
  System.out.println("Customer ["+bank.getCustomer(2).getLastName()+" "+bank.getCustomer(2).getFirstName()+"] has a balance of "+bank.getCustomer(2).getAccount(0).getBalance());
  
  
  
	}
}