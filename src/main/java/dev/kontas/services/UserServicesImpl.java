package dev.kontas.services;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import dev.kontas.daos.UserDAO;
import dev.kontas.daos.UserDAOImpl;
import dev.kontas.entities.User;

public class UserServicesImpl implements UserServices {

	private static UserDAO udao = new UserDAOImpl();

	private static Set<User> users;

	public User registerUser(String username, String password, String name) {
		// TODO Auto-generated method stub
		User user = new User(username, password, name);
		return udao.createUser(user);
	}

	public User login(String username, String password) {
		// TODO Auto-generated method stub
		for (User u : udao.getAllUsers()) {
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals(password)) {
					return u;
				} else {
					System.out.println("Wrong password");
				}
			}

		}

		return null;
	}

	public Set<User> viewUser(User supr) {
		// TODO Auto-generated method stub
		System.out.println("User List");
		Iterator<User> i = udao.getAllUsers().iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		return udao.getAllUsers();
	}

	public User createUser(User supr, User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(int USER_ID) {
		// TODO Auto-generated method stub
		users = udao.getAllUsers();

		for (User u : udao.getAllUsers()) {
			if (u.getUserId() == USER_ID) {
				users.remove(u);/// delete user here
				udao.deleteUser(USER_ID);
			}

		}
		return true;
	}

	public boolean updateUser(int id) {
		// TODO Auto-generated method stub
		Scanner com = new Scanner(System.in);
		System.out.println("What operation you want to do for id user "+udao.getUserById(id));
		System.out.println("USERNAME PASSWORD NAME ACCOUNT");
		String op=com.next();
		User u=udao.getUserById(id);
			
			if (u.getUserId() == id) {
				switch (op) {
				case "USERNAME": {
					System.out.println("What you want change username to?");
					String name = com.next();
					u.setUsername(name);
					System.out.println("Succesfully changed USERNAME!");
				}
					break;
				case "PASSWORD": {
					System.out.println("What you want change password to?");
					String password = com.next();
					u.setPassword(password);
					System.out.println("Succesfully changed PASSWORD!");
				}
					break;
				case "NAME": {
					System.out.println("What you want change name to?");
					String name = com.next();
					u.setName(name);
					System.out.println("Succesfully changed NAME!");
				}
					break;
				case "ACCOUNT": {
					System.out.println("1:Create Account 2:Delete Account?");
					int a = com.nextInt();
					System.out.println("Succesfully changed ACCOUNT INFO!");
					
				}}}
			
			udao.updateUser(u);
		return true;
	
	}

}
