package com.cimb.codetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cimb.codetest.common.WSResponseBean;
import com.cimb.codetest.services.AccountServices;

@RestController
public class AccountBalanceController {

	@GetMapping("/accountBalance")
	public WSResponseBean getAccountBalance() {
		AccountServices acc = new AccountServices();
		return acc.getAllAccountBalance();
	}
}
