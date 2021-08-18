package com.revature.dao;

import org.springframework.stereotype.Component;

@Component("dao2")
public class AccountDaoImpl2 implements AccountDao {

	public void create() {
		System.out.println("Account dao 2 create called");
	}

}
