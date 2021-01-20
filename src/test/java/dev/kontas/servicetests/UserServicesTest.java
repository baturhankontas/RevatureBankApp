package dev.kontas.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.kontas.daos.UserDAO;
import dev.kontas.daos.UserDAOImpl;
import dev.kontas.entities.User;

class UserServicesTest {
	
	private static UserDAO udao = new UserDAOImpl();
	@Test
	public void createUser() {
		User u = new User("user", "pass", "name");
		System.out.println(u);
		udao.createUser(u);
		System.out.println(u);

		User u2 = new User("user2", "pass2", "name2");
		System.out.println(u2);
		udao.createUser(u2);
		System.out.println(u2);
	}

}
