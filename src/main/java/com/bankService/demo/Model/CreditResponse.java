package com.bankService.demo.Model;

import lombok.Data;

@Data
public class CreditResponse {

	private String status;
	private String approveCode;
	private String statusDesc;
}
