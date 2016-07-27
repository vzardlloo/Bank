package com.vzard.javase.Bank;

public class CheckingAccount extends Account {
private double overdraftProtection = 0;    //͸֧����
protected SavingAccount protectedBy = null;
/**
 * ��͸֧�����˻�
 * @param init_balance
 */
public CheckingAccount(double init_balance) {  
	super(init_balance);
}
/**
 * ����SavingAccount����͸֧����
 * @param init_balance
 * @param protect
 */
public CheckingAccount(double init_balance,SavingAccount protect){
	super(init_balance);
	this.protectedBy = protect;
}
/**
 * ����Ԥ��͸֧�����б���
 * @param init_balance
 * @param overdraft
 */
public CheckingAccount(double init_balance,double overdraft){
	super(init_balance);
	this.overdraftProtection = overdraft;
	
}
/**
 * ��д withdraw ������
 * �˷�������ִ�����м�顣�����ǰ����㹻�ֲ�ȡ��amount,���������С�
	 * ��������ֲ����Ǵ���͸֧������������save �еĽ�����ֲ��ò�ֵ��balance-amount��.
	 * ����ֲ���͸֧����Ҫ�Ľ����ڵ�ǰ�ı����������û��Saving �˻������Ƿ������Ԥ��͸֧����
	 * ��������Ԥ�������ֲ�����͸֧������Ԥ�����û��Ԥ�������ȡ��ʧ�ܵ����δ��Ӱ�첢�׳��쳣��
 */

@Override
public void withdraw(double amt){  //ȡǮ
	if(balance >= amt){    //������ȡ�����
		balance -= amt;
	}else if(protectedBy != null){
			if(protectedBy.getBalance() >= (amt - balance)){ //���С��ȡ��������͸֧��Χ��
			protectedBy.balance -= (amt - balance);  //��saving account�п�Ǯ
			balance = 0;
			}else {  //ȡ��������͸֧��Χ
				throw new OverDraftException("Saving �˻����㣡",balance - amt);
			}
	  }
	else if(overdraftProtection != 0){ //Ԥ�����п�Ǯ
		  		if(overdraftProtection >= (amt - balance)){
		  			overdraftProtection -= (amt - balance);
			  		balance = 0;
		  		}else {
		  		throw new OverDraftException("����͸֧��ȣ�",balance - amt);
		  }
	  }
	}
	
}


