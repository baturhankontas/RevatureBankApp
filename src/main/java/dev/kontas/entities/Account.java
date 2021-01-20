package dev.kontas.entities;

public class Account {

	private String accountName;
	private int BANK_ACCOUNT_ID;
	private double currentBalance;
	private int USER_ID;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String accountName, int USER_ID) {
		super();
		this.accountName = accountName;
		this.BANK_ACCOUNT_ID = 0;
		this.currentBalance =0;
		this.USER_ID = USER_ID;
	}

	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public int getBANK_ACCOUNT_ID() {
		return BANK_ACCOUNT_ID;
	}
	
	public void setBANK_ACCOUNT_ID(int bANK_ACCOUNT_ID) {
		BANK_ACCOUNT_ID = bANK_ACCOUNT_ID;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public int getUSER_ID() {
		return USER_ID;
	}
	
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", BANK_ACCOUNT_ID=" + BANK_ACCOUNT_ID + ", currentBalance="
				+ currentBalance + ", USER_ID=" + USER_ID + "]";
	}
	
	
}
