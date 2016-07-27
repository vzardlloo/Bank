package com.vzard.javase.Bank;
import java.util.*;
/**
 * �������ж���
 * @author ZardLoo
 *
 */
public class Bank {    //����ģʽ��ֻ֤��һ������
	//��ǰ Bank ���ж�� Customer
	private List<Customer>  customers;
 //	int numberOfCustomers = 0;
	
	private Bank(){
		customers = new ArrayList<Customer>();
	}
	private static Bank bank = new Bank();
	public static Bank getgetBank (){
		return bank;
	}
	
	/**
	 * ���ݴ���Ĳ�������һ���µ�Customer����,���Ѹö���customers��ָ����Ԫ��
	 * @param firstname
	 * @param lastname
	 */
	public void addCustomer(String firstname,String lastname){
		//1.���ݴ���Ĳ�������һ���µ�Customer����
		Customer cust1 = new Customer(firstname,lastname);
		//2.��1�´�����Customer���󸳸�cudstomers�е�ָ��Ԫ��
		customers.add(cust1);
		//3.��ʾcoustmers������Customer���������
		//numberOfCustomers = numberOfCustomers + 1;
	}
	/**
	 * ���ر�ʾcustomers�������ж���������Customer���������
	 * @return
	 */
	public int getNumOfCustomers(){
		return customers.size();
	}
	/**
	 * ����ָ��������Ӧ��Customer����
	 * @param num
	 * @return
	 */
	public Customer getCustomer(int num){
		return customers.get(num);
	}
}