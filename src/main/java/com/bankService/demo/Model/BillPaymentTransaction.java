package com.bankService.demo.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillPaymentTransaction extends WithDrawalTransaction{

	public String kurum;
	public BillPaymentTransaction(BigDecimal payee, LocalDate date,String kurum) {
		super(payee, date);
		this.kurum=kurum;
		
	}
}
