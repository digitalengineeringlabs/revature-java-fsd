package com.revature.manager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//try-with-resources - AutoClosable
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			UserManager mgr = (UserManager) context.getBean("userMgr");
			boolean success = mgr.login(null, null);
			System.out.println(success);
			
			
			AccountManager accMgr1 = (AccountManager) context.getBean("accMgr");
			
			AccountManager accMgr2 = (AccountManager) context.getBean("accMgr");
			
			if(accMgr1 == accMgr2) {
				System.out.println("same instance");
			} else {
				System.out.println("different instance");
			}
			
			accMgr1.create();
		}
				
	}
	
}
