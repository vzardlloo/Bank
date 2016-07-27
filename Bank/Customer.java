package com.vzard.javase.Bank;
import java.util.*;
public class Customer {
private  String firstName,lastName;
private  List<Account> accounts = new ArrayList<Account>(); //代表用户有的账户属性
		
int NumOfAccount = 0;
SavingAccount saving = null;
CheckingAccount checking = null;

public Customer(String firstname,String lastname){  
	this.firstName = firstname;
	this.lastName = lastname;
	
}
public  String getFirstName(){
	return firstName;
}
public  String getLastName(){
	return lastName;
}

public void addAccount(Account acc){   //增加账户
	accounts.add(acc);
	NumOfAccount = NumOfAccount + 1;
  }
public  Account getAccount(int num) {  //返回第num个账户
	 return accounts.get(num);
}

public int getNumOfAccounts(){  //返回账户数量
	return accounts.size();
}
/**
 * getSaving:返回储蓄总数
 * @return
 */
public SavingAccount getSaving(){
	return saving;
	
}
/**
 * getChecking:返回支票总数
 * @return
 */
public CheckingAccount getChecking(){
	return checking;
}
/**
 * 
 * @param save
 */
public void setSaving(SavingAccount save){
	this.saving = save;
}

public void setChecking(CheckingAccount check){
	this.checking = check;
}
}
