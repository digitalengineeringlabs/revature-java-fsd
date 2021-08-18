package com.example.demo.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDao;
import com.example.demo.model.Account;

@Service
public class AccountManagerImpl implements AccountManager {

	@Autowired
	private AccountDao dao;
	
	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

}
