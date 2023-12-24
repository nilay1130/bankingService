package com.bankService.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WithDrawalTransaction extends Transaction{
	
	public WithDrawalTransaction(BigDecimal amount, LocalDate date) {
		super(amount, date);
		
	}

	@Override
	public  String toString() {
		return "W";
	}
	

}
