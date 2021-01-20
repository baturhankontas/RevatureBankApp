package dev.kontas.services;

import java.util.Set;

import dev.kontas.entities.Account;



public interface AccountServices {
		
	Account createAccount(String accountName, int USER_ID);
	boolean deleteAccount(int BANK_ACCOUNT_ID, int USER_ID );
	Account depositToAccount(double amount, int BANK_ACCOUNT_ID, int USER_ID);
	Account withdrawFromAccount(double amount,int BANK_ACCOUNT_ID, int USER_ID);
	void currentAccount(int userId);
	void allAccount();
	
}
