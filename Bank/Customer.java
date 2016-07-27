package com.vzard.javase.Bank;
import java.util.*;
public class Customer {
private  String firstName,lastName;
private  List<Account> accounts = new ArrayList<Account>(); //�����û��е��˻�����
		
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

public void addAccount(Account acc){   //�����˻�
	accounts.add(acc);
	NumOfAccount = NumOfAccount + 1;
  }
public  Account getAccount(int num) {  //���ص�num���˻�
	 return accounts.get(num);
}

public int getNumOfAccounts(){  //�����˻�����
	return accounts.size();
}
/**
 * getSaving:���ش�������
 * @return
 */
public SavingAccount getSaving(){
	return saving;
	
}
/**
 * getChecking:����֧Ʊ����
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
