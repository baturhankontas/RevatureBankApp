package dev.kontas.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.kontas.daos.AccountDAO;
import dev.kontas.daos.AccountDAOImpl;
import dev.kontas.entities.Account;

class AccountServicesTest {

	private static AccountDAO adao = new AccountDAOImpl();
	
	@Test
	public void createAccount() {
		Account a = new Account("testName",134);
		System.out.println(a);
		adao.createAccount(a);
		System.out.println(a);

		Account a2 = new Account("testName2",134 );
		System.out.println(a2);
		adao.createAccount(a2);
		System.out.println(a2);
		
	}
	@Test
	public void updateAccount() {
		Account a = new Account("testName",134); // Any entity before it is saved
		adao.createAccount(a);
		System.out.println(a);

		a.setCurrentBalance(100);// updating an object is modifying the object
		adao.updateAccount(a); 
		System.out.println(a);

	}

	@Test
	public void getAccount() {
		Account a = new Account("ASD",134); // Any entity before it is saved
		adao.createAccount(a);
		System.out.println(a);

		Account a2 = new Account("ASF",134 );
		System.out.println(a2);
		adao.createAccount(a2);
		System.out.println(a2);

		Account acc = adao.getAccount(a.getUSER_ID());
		System.out.println(acc);
	}
	
	@Test
	public void deleteAccount() {
		Account a = new Account("testName",134); // Any entity before it is saved
		adao.createAccount(a);
		System.out.println(a);

		Account a2 = new Account("testName2",134 );
		System.out.println(a2);
		adao.createAccount(a2);
		System.out.println(a2);

		adao.deleteAccount(a.getUSER_ID());
		adao.deleteAccount(a2.getUSER_ID());
	}

	}


