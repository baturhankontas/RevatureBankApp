package dev.kontas.services;

import java.util.Set;

import dev.kontas.entities.User;

public interface UserServices {
	
	User registerUser(String username,String password, String name);
	User login(String username, String password);
	Set<User> viewUser(User supr);
	User createUser(User supr, User u);
	boolean deleteUser(int USER_ID);
	boolean updateUser(int id);
	
	
}
