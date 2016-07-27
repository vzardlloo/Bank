package com.vzard.javase.Bank;

public class CheckingAccount extends Account {
private double overdraftProtection = 0;    //透支保护
protected SavingAccount protectedBy = null;
/**
 * 无透支保护账户
 * @param init_balance
 */
public CheckingAccount(double init_balance) {  
	super(init_balance);
}
/**
 * 采用SavingAccount进行透支保护
 * @param init_balance
 * @param protect
 */
public CheckingAccount(double init_balance,SavingAccount protect){
	super(init_balance);
	this.protectedBy = protect;
}
/**
 * 采用预设透支金额进行保护
 * @param init_balance
 * @param overdraft
 */
public CheckingAccount(double init_balance,double overdraft){
	super(init_balance);
	this.overdraftProtection = overdraft;
	
}
/**
 * 重写 withdraw 方法；
 * 此方法必须执行下列检查。如果当前余额足够弥补取款amount,则正常进行。
	 * 如果不够弥补但是存在透支保护，则尝试用save 中的金额来弥补该差值（balance-amount）.
	 * 如果弥补该透支所需要的金额大于当前的保护级别或者没有Saving 账户。则看是否采用了预设透支金额保护
	 * 若有则用预设金额来弥补，如透支金额大于预设金额或没有预设金额保护则取款失败但余额未受影响并抛出异常。
 */

@Override
public void withdraw(double amt){  //取钱
	if(balance >= amt){    //余额大于取出金额
		balance -= amt;
	}else if(protectedBy != null){
			if(protectedBy.getBalance() >= (amt - balance)){ //余额小于取出金额，但在透支范围内
			protectedBy.balance -= (amt - balance);  //从saving account中扣钱
			balance = 0;
			}else {  //取出金额大于透支范围
				throw new OverDraftException("Saving 账户余额不足！",balance - amt);
			}
	  }
	else if(overdraftProtection != 0){ //预设金额中扣钱
		  		if(overdraftProtection >= (amt - balance)){
		  			overdraftProtection -= (amt - balance);
			  		balance = 0;
		  		}else {
		  		throw new OverDraftException("超出透支额度！",balance - amt);
		  }
	  }
	}
	
}


