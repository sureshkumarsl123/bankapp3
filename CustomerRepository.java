package com.example.BankApp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankApp3.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
// practicing the git commands

}
