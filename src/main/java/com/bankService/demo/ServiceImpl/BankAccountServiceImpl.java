package com.bankService.demo.ServiceImpl;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankService.demo.Entity.BankAccount;
import com.bankService.demo.Model.BankAccountModel;
import com.bankService.demo.Model.DepositTransaction;
import com.bankService.demo.Model.WithDrawalTransaction;
import com.bankService.demo.Repository.BankAccountRepository;
import com.bankService.demo.Service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService{

	
	@Autowired
	private BankAccountRepository repo; 
	
	@Override
	public BankAccount getByAccountId(String accountId) {
		return repo.getByAccountId(accountId);
	}
	
	@Override
	public void update(BigDecimal balance,String accountnumber) {
		 repo.updateBalance(balance, accountnumber);
	}
	
	@Override
	public int callCredit(BankAccount account,BigDecimal amount) {
		    BankAccountModel mod=new BankAccountModel();
		    if(account!=null) {
			mod.setAccount(account);
			DepositTransaction t=new DepositTransaction(amount,LocalDate.now());
		    BigDecimal balance=mod.post(t);
		    repo.updateBalance(balance, account.getAccountNumber());
			return 1;
		    }
		    else {
		    	return 0;
		    }
	}
	
	@Override
	public int calldebit(BankAccount account,BigDecimal amount) {
		    BankAccountModel mod=new BankAccountModel();
		    if(account!=null) {
		    if(account.getBalance().compareTo(BigDecimal.ZERO)!=0) {
			mod.setAccount(account);
			WithDrawalTransaction t=new WithDrawalTransaction(amount,LocalDate.now());
		    BigDecimal balance=mod.post(t);
		    repo.updateBalance(balance, account.getAccountNumber());
			return 1;
		    }
		    else {
		    	return -1;
		    }
		    }
		    else {
		    	return 0;
		    }
	}
	
	
}
