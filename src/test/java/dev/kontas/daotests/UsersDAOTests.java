package dev.kontas.daotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.kontas.daos.UserDAO;
import dev.kontas.daos.UserDAOImpl;
import dev.kontas.entities.User;

class UsersDAOTests {

	private static UserDAO udao = new UserDAOImpl();

	@Test
	public void createUser() {
		User u = new User("usertest", "passtest", "nametest");
		System.out.println(u);
		udao.createUser(u);
		System.out.println(u);

		User u2 = new User("usertest2", "passtest2", "nametest2");
		System.out.println(u2);
		udao.createUser(u2);
		System.out.println(u2);
	}

	@Test
	public void updateUser() {
		User u = new User("usertest1", "passtest1", "nametest1");
		udao.createUser(u);
		System.out.println(u);

		u.setName("updated name");
		udao.updateUser(u); 
		System.out.println(u);

	}

	@Test
	public void getUser() {
		User u = new User("usertest","passtest1","nametest1"); 
		udao.createUser(u);
		System.out.println(u);

		User u2 = new User("usertest2","passtest2","nametest2");
		udao.createUser(u2);
		System.out.println(u2);

		User user = udao.getUserById(u.getUserId());
		System.out.println(user);
	}
	
	@Test
	public void deleteUser() {
		User u = new User("usertest","passtest1","nametest1"); 
		udao.createUser(u);
		System.out.println(u);

		User u2 = new User("usertest2","passtest2","nametest2");
		udao.createUser(u2);
		System.out.println(u2);

		udao.deleteUser(u.getUserId());
		udao.deleteUser(u2.getUserId());
	}
	

}
