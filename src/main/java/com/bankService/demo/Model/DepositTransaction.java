package com.bankService.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDate;





public class DepositTransaction extends Transaction {

	public DepositTransaction(BigDecimal amount, LocalDate date) {
		super(amount, date);
		
	}

	@Override
	public  String toString() {
		return "D";
	}
	
	
}
