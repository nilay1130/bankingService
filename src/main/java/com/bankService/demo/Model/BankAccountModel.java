package com.bankService.demo.Model;

import java.math.BigDecimal;

import com.bankService.demo.Entity.BankAccount;

import lombok.Data;

@Data
public class BankAccountModel {
	
	private BankAccount account;
	private Transaction transaction;
	
	public BigDecimal post(Transaction t) {
		if(t.toString().equals("D")) {
			return credit(t.getAmount());
		}
		else if(t.toString().equals("W")) {
			return debit(t.getAmount());
		}
		return BigDecimal.valueOf(0);
	}
	
	public BigDecimal credit(BigDecimal amount) {
		return account.getBalance().add(amount);
	}
	
   public BigDecimal debit(BigDecimal amount) {
		return account.getBalance().subtract(amount);
	}
	

}
