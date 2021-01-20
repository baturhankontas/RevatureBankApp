package dev.kontas.daos;

import java.util.Set;

import dev.kontas.entities.Account;

public interface AccountDAO {
//CRUD

	
	
		//CREATE
		boolean createAccount(Account account);
		
		//READ
		
		Account getAccount(int id);
		
		Set<Account> getAllAccount();
		
		//UPDATE
		
		boolean updateAccount(Account account);
		
		//DELETE
		
		boolean deleteAccount(int id);
			
}
