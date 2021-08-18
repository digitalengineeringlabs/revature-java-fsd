package com.revature.dao;

import org.springframework.stereotype.Component;

@Component("dao1")
public class AccountDaoImpl implements AccountDao {

	public void create() {
		System.out.println("Account dao create called");
	}

}
