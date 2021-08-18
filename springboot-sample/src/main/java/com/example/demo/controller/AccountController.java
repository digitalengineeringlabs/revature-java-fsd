package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.manager.AccountManager;
import com.example.demo.model.Account;

@RestController
@RequestMapping(path="/accounts")
public class AccountController {
	
	@Autowired
	private AccountManager manager;

	@GetMapping(produces = "application/json")
	public List<Account> getAccounts(){
		return manager.findAll();
	}

	@GetMapping(path="/{id}", produces = "application/json")
	public Account getAccount(@PathVariable int id){
		return new Account("Checking "+id);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Object> addAccount(@RequestBody Account account){
		System.out.println(account.getName());
		
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(1) //should be replaced with db serial
                 .toUri();

		 return ResponseEntity.created(location).build();
	}
	
	
}
