package com.bankService.demo.Service;

import java.math.BigDecimal;

import com.bankService.demo.Entity.BankAccount;

public interface BankAccountService {
	 public BankAccount getByAccountId(String accountId);
	 public void update(BigDecimal balance,String accountnumber);
	 public int callCredit(BankAccount account,BigDecimal amount);
	 public int calldebit(BankAccount account,BigDecimal amount);
	
	
}
