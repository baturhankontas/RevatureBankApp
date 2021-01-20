package dev.kontas.services;

import dev.kontas.daos.AccountDAO;
import dev.kontas.daos.AccountDAOImpl;

import dev.kontas.entities.Account;


public class AccountServicesImpl implements AccountServices {
	
	private static AccountDAO adao = new AccountDAOImpl();
	
	
	public Account createAccount(String accountName, int USER_ID) {
		// TODO Auto-generated method stub
		Account acc= new Account(accountName, USER_ID);
		adao.createAccount(acc);
		return acc;
	}

	public boolean deleteAccount(int BANK_ACCOUNT_ID, int USER_ID) {
		// TODO Auto-generated method stub
		
		for (Account a : adao.getAllAccount()) {
			if (a.getBANK_ACCOUNT_ID()==BANK_ACCOUNT_ID) {
				if(a.getUSER_ID()==USER_ID)
				{
					if (a.getCurrentBalance() == 0) {
						adao.deleteAccount(BANK_ACCOUNT_ID);
						return true;
						
					} else {
						System.out.println("Account balance isn't 0.\n Please withdraw "+a.getCurrentBalance() +", first! ");
					}
				}
				}
			} 
	
		return false;
	}

	public Account depositToAccount(double amount, int BANK_ACCOUNT_ID, int USER_ID) {
		// TODO Auto-generated method stub
		for (Account a : adao.getAllAccount()) {
			if (a.getBANK_ACCOUNT_ID()==BANK_ACCOUNT_ID) {
				a.setCurrentBalance(amount+a.getCurrentBalance());
				adao.updateAccount(a);
				return a;
			}
			}
		
		return null;
	}

	public Account withdrawFromAccount(double amount, int BANK_ACCOUNT_ID, int USER_ID) {
		// TODO Auto-generated method stub
		for (Account a : adao.getAllAccount()) {
			if (a.getBANK_ACCOUNT_ID()==BANK_ACCOUNT_ID) {
				if(a.getCurrentBalance()==amount || a.getCurrentBalance()>amount ) {
					a.setCurrentBalance(a.getCurrentBalance()-amount);
					adao.updateAccount(a);
					System.out.println(amount + " have been withdrawn from Account Number 2" + BANK_ACCOUNT_ID);
				}
				else {
					System.out.println("There is not enough money in the account.");
				}
			}
			}
		return null;
	}
	

	public void currentAccount(int userId) {
		// TODO Auto-generated method stub
		for(Account a:adao.getAllAccount()) {
			if (a.getUSER_ID()==userId) {
				System.out.println(a);
				
			}
		}
		
	}
	public void allAccount() {
		// TODO Auto-generated method stub
		for(Account a:adao.getAllAccount()) {
			
				System.out.println(a);
				
		}
		
		
	}
}


