package com.bankService.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankService.demo.Entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

}
