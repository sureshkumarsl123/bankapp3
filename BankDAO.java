package com.example.BankApp3.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.BankApp3.entity.Customer;
import com.example.BankApp3.repository.CustomerRepository;
import com.example.BankApp3.exceptions.NotFoundException;



@Service
public class BankDAO
{
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	private EntityManager entityManager;
	
	private long accountNo;
	
	private long amount;
	

	
	
	
	public long getAccountNo() {
		return accountNo;
	}

public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}






	public long getAmount() {
		return amount;
	}






	public void setBalance(long amount) {
		this.amount = amount;
	}
	
	public Customer findById(Long accountNo) { 
		return this.entityManager.find(Customer.class, accountNo);
	}


	@Transactional(propagation = Propagation.MANDATORY,rollbackFor = NotFoundException.class )
	public void addAmount(Long accountNo, long amount) throws NotFoundException
	{
		Customer customer = this.findById(accountNo);
		if(customer == null)
		{
			throw new NotFoundException("Account not found " );
		}
		long newBalance = customer.getBalance() + amount;
		
		customer.setBalance(newBalance);
		
		
//		return customer;
	}

	//

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = NotFoundException.class)
public void transfer(Long fromAccountNo, Long toAccountNo, long amount) throws NotFoundException 
{

addAmount(fromAccountNo, -amount);
addAmount(toAccountNo, +amount);
//return customer;
}
}