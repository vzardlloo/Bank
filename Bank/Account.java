package com.vzard.javase.Bank;

public class Account {
public double balance;  //��ǰ���

public Account(double init_balance){  //Ϊ��ֵ
	this.balance = init_balance;
	
}

public double getBalance(){   //��ȡ���
	return balance;
}
/**
 * ��Ǯ����
 * @param addBalance����Ǯ��Ǯ��
 * @return�����ش���Ƿ�ɹ�
 */

public boolean deposit(double addBalance){  //��Ǯ
	if(addBalance >=0) {
	balance = balance + addBalance;
	
	return true;
	}else {
	return false;
	}
}
/**
 * ȡǮ����
 * @param cutBalance��ȡ���Ǯ��
 * @return������ȡ���Ƿ�ɹ�
 */
public void withdraw(double cutBalance){  //ȡǮ
	if(cutBalance > balance){
	throw new OverDraftException("���㣡",balance - cutBalance);
   }
	balance -= cutBalance;
 }



}
