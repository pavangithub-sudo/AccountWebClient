package com.dev.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dev.model.Account;
import com.dev.model.AnotherAccount;
@FeignClient(value = "account-consumer", url = "http://localhost:2222/")
public interface AccountClient {

	@PostMapping("/saveAccount")
	public Account saveAccount(@RequestBody Account account);

	@GetMapping("/retrieveAccounts")
	public List<Account> getAllAccounts();

}


