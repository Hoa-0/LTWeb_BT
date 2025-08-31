package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.dao.UserDao;
import vn.iotstar.models.User;
import vn.iotstar.utils.DBConnect;

public class UserDaoImpl implements UserDao {
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users(username,password,email,fullname,phone) VALUES(?,?,?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getPhone());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		String sql = "SELECT * FROM users WHERE email=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "SELECT * FROM users WHERE username=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		String sql = "SELECT * FROM users WHERE phone=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, phone);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
