package com.bankService.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public  class Transaction {
	
	private BigDecimal amount;
	private LocalDate date;
	
	public  String toString() {
		return "T";
	}
	
	
    

}
