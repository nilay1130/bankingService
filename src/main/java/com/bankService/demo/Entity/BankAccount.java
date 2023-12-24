package com.bankService.demo.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="bank_account")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@Column(name="owner")
	private String owner;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="balance")
	private BigDecimal balance;

}
