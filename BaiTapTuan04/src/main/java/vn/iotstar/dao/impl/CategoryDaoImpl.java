package vn.iotstar.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.models.Category;
import vn.iotstar.utils.DBConnect;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public void insert(Category cate) {
		String sql = "INSERT INTO Categories(cate_name, icons, user_id) VALUES(?,?,?)";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cate.getCateName());
			ps.setString(2, cate.getIcons());
			ps.setInt(3, cate.getUserId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category cate) {
		String sql = "UPDATE Categories SET cate_name=?, icons=? WHERE cate_id=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cate.getCateName());
			ps.setString(2, cate.getIcons());
			ps.setInt(3, cate.getCateId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int cateId) {
		String sql = "DELETE FROM Categories WHERE cate_id=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, cateId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category findById(int cateId) {
		String sql = "SELECT * FROM Categories WHERE cate_id=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Category c = new Category();
				c.setCateId(rs.getInt("cate_id"));
				c.setCateName(rs.getString("cate_name"));
				c.setIcons(rs.getString("icons"));
				c.setUserId(rs.getInt("user_id"));
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM Categories";
		try (Connection conn = new DBConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Category c = new Category();
				c.setCateId(rs.getInt("cate_id"));
				c.setCateName(rs.getString("cate_name"));
				c.setIcons(rs.getString("icons"));
				c.setUserId(rs.getInt("user_id"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Category> findByUser(int userId) {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM Categories WHERE user_id=?";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setCateId(rs.getInt("cate_id"));
				c.setCateName(rs.getString("cate_name"));
				c.setIcons(rs.getString("icons"));
				c.setUserId(rs.getInt("user_id"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}