package com.bankService.demo.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankService.demo.Entity.BankAccount;
import com.bankService.demo.Model.BankAccountModel;
import com.bankService.demo.Model.CreditRequest;
import com.bankService.demo.Model.CreditResponse;
import com.bankService.demo.Model.DepositTransaction;
import com.bankService.demo.Model.WithDrawalTransaction;
import com.bankService.demo.Service.BankAccountService;



@Controller
@RequestMapping("/api/v1/")

public class BankAccountController {
	
	@Autowired
	private BankAccountService service;

	@PostMapping(value = {"account/credit/{accountNumber}"})
	public ResponseEntity<CreditResponse>  callCredit(@PathVariable("accountNumber") String accountNumber,@RequestBody CreditRequest request){
		CreditResponse res=new CreditResponse();
		
		BankAccount account=service.getByAccountId(accountNumber);
		try {
			
		 int result=service.callCredit(account,request.getAmount());
		 if (result==1) {
			
			
			res.setStatus("OK");
			res.setStatusDesc("Success");
			
		 }
		else {
			res.setStatus("FAILED");
			res.setStatusDesc("Account couldnt found");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		}
		catch (Exception e){
		res.setStatus("99");
		res.setStatusDesc("Beklenmeyen sistem hatası. :" + e.getLocalizedMessage());
		e.printStackTrace();
		}
	
	
	return ResponseEntity.ok( res );
	}
	@PostMapping(value = {"account/dedit/{accountNumber}"})
	public ResponseEntity<CreditResponse>  calldebit(@PathVariable("accountNumber") String accountNumber,@RequestBody CreditRequest request){
		CreditResponse res=new CreditResponse();
		BankAccountModel mod=new BankAccountModel();
		BankAccount account=service.getByAccountId(accountNumber);
		try {
		
			int result=service.callCredit(account,request.getAmount());
			if(result==1) {
			res.setStatus("OK");
			res.setStatusDesc("Success");
			}
			else if(result==-1){
				res.setStatus("FAILED");
				res.setStatusDesc("Account couldnt be updated");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
			}
			
		
		else {
			res.setStatus("FAILED");
			res.setStatusDesc("Account couldnt found");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
		}
		catch (Exception e){
		res.setStatus("99");
		res.setStatusDesc("Beklenmeyen sistem hatası. :" + e.getLocalizedMessage());
		e.printStackTrace();
		}
	
	
	return ResponseEntity.ok( res );
	}
}
