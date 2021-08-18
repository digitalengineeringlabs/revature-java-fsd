package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Recurring Deposit"));
		return accounts;
	}

}
