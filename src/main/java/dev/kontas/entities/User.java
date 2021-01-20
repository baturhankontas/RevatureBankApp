package dev.kontas.entities;


public class User {

	private String username;
	private String password;
	private String name;
	private int USER_ID;
	private String superUser;
	

	
	public User() {
		super();
	}
	
	
	public User(String username,String password, String name) {
		super();
		this.username = username;
		this.name = name;
		this.USER_ID=0;
		this.password=password;
		this.superUser="N";
		
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserId() {
		return USER_ID;
	}


	public void setUserId(int USER_ID) {
		this.USER_ID = USER_ID;
	}

	
	public String getSuperUser() {
		return superUser;
	}
	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}
	@Override
	public String toString() {
		return "User " +name +  "\nusername=" + username + "\t password=" + password + "\t name=" + name +"\t user id " +USER_ID+"";
	}
	
}
