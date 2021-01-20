package dev.kontas.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import dev.kontas.entities.Account;
import dev.kontas.util.JDBCConnection;

public class AccountDAOImpl implements AccountDAO {
	public static Connection conn = JDBCConnection.getConnection();

	public boolean createAccount(Account account) {
		// TODO Auto-generated method stub
		try {

			String sql = "CALL add_accounts(?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, account.getAccountName());
			cs.setString(2, Integer.toString(account.getUSER_ID()));

			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Account getAccount(int id) {
	// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM accounts WHERE USER_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Account a = new Account();
				a.setAccountName(rs.getString("ACCOUNTNAME"));
				a.setBANK_ACCOUNT_ID(rs.getInt("BANK_ACCOUNT_ID"));
				a.setCurrentBalance(rs.getInt("CURRENTBALANCE"));
				a.setUSER_ID(rs.getInt("USER_ID"));

				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Set<Account> getAllAccount() {
		// TODO Auto-generated method stub
		Set<Account> account = new HashSet<Account>();
		try {

			String sql = "SELECT * FROM accounts";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Account a = new Account();
				a.setAccountName(rs.getString("ACCOUNTNAME"));
				a.setBANK_ACCOUNT_ID(rs.getInt("BANK_ACCOUNT_ID"));
				a.setCurrentBalance(rs.getInt("CURRENTBALANCE"));
				a.setUSER_ID(rs.getInt("USER_ID"));

				account.add(a);

				

			}

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "UPDATE accounts SET accountName = ?, currentBalance = ?, USER_ID = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, account.getAccountName());
			ps.setString(2, Double.toString(account.getCurrentBalance()));
			ps.setString(3, Integer.toString(account.getUSER_ID()));
			ps.setString(4, Integer.toString(account.getBANK_ACCOUNT_ID()));
			
			

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean deleteAccount(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "DELETE accounts WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


}
