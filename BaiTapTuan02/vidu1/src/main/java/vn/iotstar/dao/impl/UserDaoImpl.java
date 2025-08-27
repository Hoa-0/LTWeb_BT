package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.dao.UserDao;
import vn.iotstar.models.UserModels;
import vn.iotstar.utils.DBConnect;

public class UserDaoImpl implements UserDao {

    @Override
    public UserModels get(String username) {
        String sql = "SELECT * FROM users WHERE username=?";
        try (Connection conn = new DBConnect().getConnection();   // ✅ sửa chỗ này
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserModels user = new UserModels();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setRoleId(rs.getInt("role_id"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
