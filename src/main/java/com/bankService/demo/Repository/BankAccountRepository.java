package com.bankService.demo.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bankService.demo.Entity.BankAccount;

import jakarta.transaction.Transactional;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

	@Transactional
	@Query("select e from BankAccount e where e.accountNumber=?1 ")
	BankAccount getByAccountId(String accountId);
	
	@Transactional
	@Modifying
	@Query("update BankAccount e set e.balance = ?1 where e.accountNumber = ?2")
	void updateBalance(BigDecimal balance,String accountId);
}
