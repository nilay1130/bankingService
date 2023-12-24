package com.bankService.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankService.demo.Entity.BankAccount;

import com.bankService.demo.ServiceImpl.BankAccountServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@InjectMocks
	 private BankAccountServiceImpl service;
	
	private BankAccount account;
	
	    @Test
	    public void getBalance()
	    {
	     
		   account=service.getByAccountId("12345");
	      assertThat(account.getBalance()).isEqualTo("100");
	    }
	    
	    @Test
	    public void credit() {
	    	 
	    	 BankAccount account=service.getByAccountId("12345");
	    	 service.callCredit(account, new BigDecimal(20));
	    	 account=service.getByAccountId("12345");
	    	 assertThat(account.getBalance()).isEqualTo("120");
	    }
	   
	    

}
