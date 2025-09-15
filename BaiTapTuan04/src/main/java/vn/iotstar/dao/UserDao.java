package vn.iotstar.dao;

import vn.iotstar.models.UserModels;

public interface UserDao {
	void insert(UserModels user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	UserModels get(String username);

	void update(UserModels user);
}