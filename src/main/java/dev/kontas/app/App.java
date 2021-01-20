package dev.kontas.app;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

import dev.kontas.entities.Account;
import dev.kontas.entities.User;
import dev.kontas.services.AccountServices;
import dev.kontas.services.AccountServicesImpl;
import dev.kontas.services.UserServices;
import dev.kontas.services.UserServicesImpl;
import dev.kontas.exceptions.*;


public class App {

	private static Scanner scan = new Scanner(System.in);
	private static UserServices userv = new UserServicesImpl();
	private static AccountServices aserv = new AccountServicesImpl();
	private static User loggedInEmployee = null;
	private static Account a = null;

	public static void main(String[] args) {
		UsernameValidator validator = new UsernameValidatorImpl();
		while (true) {
			
			boolean loggedIn = false;
			System.out.println("Welcome to bank !!");
			System.out.println("1: for enrollment, 2: login");
			int choice = scan.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Please enter a username");
				String username = scan.next();
				System.out.println("Please enter a password");
				String password = scan.next();
				System.out.println("Please enter your name");
				String name = scan.next();
				try {
					boolean isValid;
					isValid = validator.validUsername(username) && validator.validUsername(password);
					System.out.println("Account created successfully");		
					User usr = userv.registerUser(username, password, name);
					System.out.println(usr);
				} catch (InappropriateCharacterException e) {
					System.out.println("You used an inappropriate character");
				} catch (UsernameTooShortException e) {
					System.out.println("Username or password was too short");
					System.out.println(e.getMessage() + " your username was this long: " + e.inputLength);
					System.out.println(e.getMessage() + " your password was this long: " + password.length());
				}
				
			}
				break;

			case 2: {
				System.out.println("Please enter your username");
				String username = scan.next();
				System.out.println("Please enter your password");
				String password = scan.next();
				loggedInEmployee = userv.login(username, password);
				if (loggedInEmployee != null) {
					loggedIn = true;
					System.out.println(loggedInEmployee);
					
				}
			}
				break;
			}
			while (loggedIn) {
				if (loggedIn) {
					if (loggedInEmployee.getSuperUser().equals("Y")) {
						System.out.println("Entered as super user");
						System.out.println(
								"1:view all users\n2:create new user\n3:update a user\n4:delete a user\n5:See all accounts\n6:Log Out");
						int decision = scan.nextInt();
						switch (decision) {
						case 1: {
							userv.viewUser(loggedInEmployee);
						}
							;
							break;
						case 2: {
							System.out.println("Please enter a username");
							String username = scan.next();
							System.out.println("Please enter a password");
							String password = scan.next();
							System.out.println("Please enter your name");
							String name = scan.next();
							User usr = userv.registerUser(username, password, name);
							System.out.println(usr);
						}
							;
							break;
						case 3: {                ///mess with tomorrow
							System.out.println("Please enter user id for update function");
							int uId=scan.nextInt();
							
							userv.updateUser(uId);
							
							}
						
							;
							break;
						case 4: {
							System.out.println("Please enter user id for delete");
							int uId = scan.nextInt();
							System.out.println("Please enter user name for delete");
							int uName = scan.nextInt();
							userv.deleteUser(uId);
						}
							;
							break;
						case 5: {
							System.out.println("Accounts:");
							aserv.allAccount();
						}
							;
							break;
						case 6: {
							loggedIn = false;
						}
							;
							break;

						}
					} else {
						System.out.println("Welcome");
						System.out.println("Accounts:");
						aserv.currentAccount(loggedInEmployee.getUserId());
						System.out.println("1:Create Account\n2:Delete Account\n3:Deposit\n4:Withdrawl\n5:See All Accounts\n6:Log Out");
						int decision = scan.nextInt();
						

						switch (decision) {
						case 1: {
							System.out.println("Please enter a account name");
							String accName = scan.next();
							int userId = loggedInEmployee.getUserId();
							a = aserv.createAccount(accName, userId);
							System.out.println("Account created\nName is :" + accName + "\nBank Account ID : "
									+ a.getBANK_ACCOUNT_ID());

						}
							;
							break;
						case 2: {
							System.out.println("Please enter account id for delete");
							int accId = scan.nextInt();
							int userId = loggedInEmployee.getUserId();
							aserv.deleteAccount(accId, userId);

						}
							;
							break;
						case 3: {
							System.out.println("Please enter account id for deposit");
							int accId = scan.nextInt();
							System.out.println("Please enter amount id for deposit");
							double amount = scan.nextDouble();
							int userId = loggedInEmployee.getUserId();
							aserv.depositToAccount(amount, accId, userId);
							System.out.println(amount + " added to account number " + accId);

						}
							;
							break;
						case 4: {
							System.out.println("Please enter account id for withdraw");
							int accId = scan.nextInt();
							System.out.println("Please enter amount id for withdraw");
							double amount = scan.nextDouble();
							int userId = loggedInEmployee.getUserId();
							aserv.withdrawFromAccount(amount, accId, userId);

						}
							;
							break;
						case 5: {
							System.out.println("Accounts:");
							aserv.currentAccount(loggedInEmployee.getUserId());
						}
							;
							break;
						case 6: {
							loggedIn = false;
						}
							;
							break;

						}
					}

				}

			}

		}

	}

}
