package com.vzard.javase.Bank;

public class Account {
public double balance;  //当前余额

public Account(double init_balance){  //为余额赋值
	this.balance = init_balance;
	
}

public double getBalance(){   //获取余额
	return balance;
}
/**
 * 存钱方法
 * @param addBalance：存钱的钱数
 * @return：返回存款是否成功
 */

public boolean deposit(double addBalance){  //存钱
	if(addBalance >=0) {
	balance = balance + addBalance;
	
	return true;
	}else {
	return false;
	}
}
/**
 * 取钱方法
 * @param cutBalance：取款的钱数
 * @return：返回取款是否成功
 */
public void withdraw(double cutBalance){  //取钱
	if(cutBalance > balance){
	throw new OverDraftException("余额不足！",balance - cutBalance);
   }
	balance -= cutBalance;
 }



}
