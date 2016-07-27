package com.vzard.javase.Bank;

public class SavingAccount extends Account  {
	private double interestRate;
	//¹¹ÔìÆ÷
	public SavingAccount(double init_balance,double interestRate){
		super(init_balance);
		this.interestRate = interestRate;
	}
	public double getInterestRate(){
		return interestRate;
	}
}
