package dev.kontas.daos;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.HashSet;

import java.util.Set;

import dev.kontas.entities.User;
import dev.kontas.util.JDBCConnection;


public class UserDAOImpl implements UserDAO {
	
	public static Connection conn = JDBCConnection.getConnection();
	

	public User createUser(User user) {
		// TODO Auto-generated method stub
		try {
			
			
			String sql = "CALL add_person(?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getName());
			cs.setString(4, user.getSuperUser());
			
			cs.execute();
			
			

		
		} catch (SQLException e) {
		e.printStackTrace();
		}

		return user;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT * FROM person WHERE USER_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				User u = new User();
				u.setUsername(rs.getString("USERNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setName(rs.getString("NAME"));
				u.setUserId(rs.getInt("USER_ID"));
				u.setSuperUser(rs.getString("SYSADMIN"));
				

				return u;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
		Set<User> users= new HashSet<User>();
		try {

			String sql = "SELECT * FROM person";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User u = new User();
				u.setUsername(rs.getString("USERNAME"));
				u.setPassword(rs.getString("PASSWORD"));
				u.setName(rs.getString("NAME"));
				u.setUserId(rs.getInt("USER_ID"));
				u.setSuperUser(rs.getString("SYSADMIN"));
				

				users.add(u);

				

			}

			return users;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		return users;
	}
	
	

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE person SET username = ?, password = ?, name =?, sysadmin=? WHERE USER_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSuperUser());
			ps.setString(5, Integer.toString(user.getUserId()));
			

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		return false;
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "DELETE person WHERE USER_ID = ?";
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
