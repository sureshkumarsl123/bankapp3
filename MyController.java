package com.example.BankApp3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.BankApp3.entity.Customer;
import com.example.BankApp3.exceptions.NotFoundException;
import com.example.BankApp3.repository.CustomerRepository;
import com.example.BankApp3.service.BankDAO;

@RestController
//@RequestMapping("/api/customer")
public class MyController 
{
	@Autowired
	private BankDAO bankdao;
	
	@Autowired
	private CustomerRepository customerrepository;
	

	@CrossOrigin(origins="/http://localhost:4200")
	@GetMapping("/Customer")
//	@GetMapping
	public List<Customer> getAllCustomers()
	{
		List<Customer> customer=customerrepository.findAll();
		return customer;
	}
	
	
	
	@GetMapping("/{accountNo}")
	public Customer getCustomerByaccountNo(@PathVariable (value="accountNo") long accountNo )
	{
		return customerrepository.findById(accountNo)
				.orElseThrow(()-> new NotFoundException("customer not found"));
		
	}
	
	// create user
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerrepository.save(customer);
	}
	
	
	@PutMapping("/{accountNo}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable (value="accountNo") long accountNo)
	{
		Customer existing= customerrepository.findById(accountNo)
			.orElseThrow(()-> new NotFoundException("customer not found"));
		existing.setAccountNo(customer.getAccountNo());
		existing.setName(customer.getName());
		existing.setBalance(customer.getBalance());
		
		return customerrepository.save(existing);
		
		
	}
	
	@DeleteMapping("/{accountNo}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable (value="accountNo") long accountNo)
	{
		Customer existing= customerrepository.findById(accountNo)
				.orElseThrow(()-> new NotFoundException("customer not found"));
		
		customerrepository.delete(existing);
		 return  ResponseEntity.ok().build();
	}

	
	@RequestMapping("/transfer/{accountNo1}/{accountNo2}/{amount}")
	public  String  transaction (@PathVariable (value="accountNo1") long accountNo1,@PathVariable (value="accountNo2") long accountNo2,@PathVariable (value="amount") long amount) throws NotFoundException 
	{
		
		try
		{
			
		bankdao.transfer(accountNo1, accountNo2, amount);
		return "transaction successfull";
		}
		catch(NotFoundException  e)
		{
			
			return "transaction failed";
		}
	}

	
	

}
