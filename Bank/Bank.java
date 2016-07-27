package com.vzard.javase.Bank;
import java.util.*;
/**
 * 代表银行对象
 * @author ZardLoo
 *
 */
public class Bank {    //单例模式保证只有一个银行
	//当前 Bank 中有多个 Customer
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
	 * 根据传入的参数创建一个新的Customer对象,并把该对象customers中指定的元素
	 * @param firstname
	 * @param lastname
	 */
	public void addCustomer(String firstname,String lastname){
		//1.根据传入的参数创建一个新的Customer对象
		Customer cust1 = new Customer(firstname,lastname);
		//2.把1新创建的Customer对象赋给cudstomers中的指定元素
		customers.add(cust1);
		//3.表示coustmers变量中Customer对象的数量
		//numberOfCustomers = numberOfCustomers + 1;
	}
	/**
	 * 返回表示customers变量中有多少真正的Customer对象的整数
	 * @return
	 */
	public int getNumOfCustomers(){
		return customers.size();
	}
	/**
	 * 返回指定索引对应的Customer对象
	 * @param num
	 * @return
	 */
	public Customer getCustomer(int num){
		return customers.get(num);
	}
}