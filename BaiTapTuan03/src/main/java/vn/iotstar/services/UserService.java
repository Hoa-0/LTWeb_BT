package vn.iotstar.services;

import vn.iotstar.models.UserModels;

public interface UserService {
    boolean register(String username, String password, String email, String fullname, String phone);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistPhone(String phone);

    UserModels login(String username, String password);

    UserModels get(String username);
}
