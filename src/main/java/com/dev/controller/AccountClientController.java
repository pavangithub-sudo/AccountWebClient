package com.dev.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.constants.Constants;
import com.dev.exception.ErrorDetails;
import com.dev.exception.ErrorResponse;
//import com.dev.exception.NotfoundException;
import com.dev.model.Account;
import com.dev.model.AnotherAccount;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/AccountClient")
public class AccountClientController {
	
	@Autowired
	AccountClient accountClient;
	
	@Autowired
	AccountClient2 accountClient2;
	
	private int attempt=1;
	
	@PostMapping("/saveAccount")
	//public Account SaveAccount(@RequestHeader Map<String, String> headers, @RequestBody Account account) {//throws NotfoundException{
		public Account SaveAccount(@RequestBody Account account) {//throws NotfoundException{

		try {
			if(account != null) {
				validateRequestBody(account);
		//		Map<String, String> map = new LinkedCaseInsensitiveMap<>();
		//		map.putAll(headers);
			return accountClient.saveAccount(account);
		} else {
			return account;
		}
		}catch (Exception e) {
		
		
		}
		return null;
	}
	
	private void validateRequestBody(Account account) {
		List<ErrorDetails> errorDetails = new ArrayList<>();
		
		if(account.getName() != null && account.getName().isEmpty()) {
			errorDetails.add(new ErrorDetails("name", "1001", "name is mandatory", "requestBody"));
		}
		if(account.getSalary() != null && !account.getSalary().equals(Constants.EMPTYSTRING)) {
			errorDetails.add(new ErrorDetails("salary", "1002", "salary is mandatory", "requestBody"));
		}
		if(!errorDetails.isEmpty()) {
		//	throw new NotfoundException(new ErrorRespons( new ErrorResponse(Constants.NAMESPACE, Constants.MSG));
		}
		
	}

	@GetMapping("/AccountList")
	@CircuitBreaker(name="accountconsumer",fallbackMethod = "accountConsumerGetAccounts")
//	@Retry(name="accountconsumer",fallbackMethod = "accountConsumerGetAccounts")
	public List<Account> accounts(){
		return accountClient.getAllAccounts();
	}
	
	
	
	public List<Account> accountConsumerGetAccounts(Exception ex) {
		List<Account> list=Arrays.asList(new Account(1, "samplemessage1", (double) 5),
				new Account(2, "samplemessage1", (double)9));
		System.out.println("retry method called "+attempt++ +" times "+" at ");
		return list;
	}
	
	
	@PostMapping("/insertAccount")
		public AnotherAccount SaveAccountFromMethod2(@RequestBody AnotherAccount account) {
			return accountClient2.saveAccountFromService2(account);
	}
	
	@GetMapping("/getAccountList")
	public List<AnotherAccount> accountsByService2(){
		return accountClient2.getAllAccountsFromService2();
	}
	
	
	
}
