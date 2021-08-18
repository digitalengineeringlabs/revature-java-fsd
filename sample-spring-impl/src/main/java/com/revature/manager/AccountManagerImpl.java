package com.revature.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.dao.AccountDao;

@Component("accMgr")
@Scope("prototype")
public class AccountManagerImpl implements AccountManager {
	
	@Autowired
	@Qualifier("dao2")
	private AccountDao dao;

	public void create() {
		System.out.println("create called");
		dao.create();
	}

}
