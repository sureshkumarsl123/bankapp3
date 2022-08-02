package com.example.BankApp3.entity;

import javax.annotation.Generated;
import javax.persistence.*;



@Entity
//@Table(name="customer")
public class Customer
{
	@Id
//	@GeneratedValue()
	private long accountNo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="balance")
	private long balance;
	
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
	
}
