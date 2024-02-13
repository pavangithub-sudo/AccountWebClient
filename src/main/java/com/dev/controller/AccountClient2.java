package com.dev.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dev.model.AnotherAccount;

@FeignClient(value = "account-consumer2", url = "http://localhost:5555/")
public interface AccountClient2 {

	@PostMapping("/storeAccount")
	public AnotherAccount saveAccountFromService2(@RequestBody AnotherAccount account);

	@GetMapping("/getAllAccounts")
	public List<AnotherAccount> getAllAccountsFromService2();

}
