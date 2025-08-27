package vn.iotstar.services;

import vn.iotstar.models.UserModels;

public interface UserService {
    UserModels login(String username, String password);
    UserModels get(String username);
}
