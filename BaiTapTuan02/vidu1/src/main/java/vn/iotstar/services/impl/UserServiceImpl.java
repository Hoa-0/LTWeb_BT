package vn.iotstar.services.impl;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModels;
import vn.iotstar.services.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserModels login(String username, String password) {
        UserModels user = userDao.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user; // Đúng user/pass
        }
        return null; // Sai
    }

    @Override
    public UserModels get(String username) {
        return userDao.get(username);
    }
}
