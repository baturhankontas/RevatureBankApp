package dev.kontas.daos;

import java.util.Set;

import dev.kontas.entities.User;


public interface UserDAO {
//CRUD

	
	
	//CREATE
	User createUser(User user);
	
	//READ
	
	User getUserById(int id);
	
	Set<User> getAllUsers();
	
	//UPDATE
	
	boolean updateUser(User user);
	
	//DELETE
	
	boolean deleteUser(int id);
	
	
}
