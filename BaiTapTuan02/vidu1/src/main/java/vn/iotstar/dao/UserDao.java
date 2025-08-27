package vn.iotstar.dao;

import vn.iotstar.models.UserModels;

public interface UserDao {
    UserModels get(String username);
}
