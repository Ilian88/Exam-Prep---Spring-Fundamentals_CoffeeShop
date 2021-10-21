package com.example.coffee_shop.service;

import com.example.coffee_shop.model.entity.UserEntity;
import com.example.coffee_shop.model.service.UserLoginService;
import com.example.coffee_shop.model.service.UserRegisterService;
import com.example.coffee_shop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    Boolean checkIfUserExistsByUsername(String username);

    Boolean checkIfUserExistsByEmail(String email);

    void saveUser(UserRegisterService map);

    boolean checkIfUserExistsByUsernameAndPassword(String username, String password);

    void loginUser(UserLoginService map);

    UserEntity findCurrentUser();

    List<UserViewModel> getAllEmployees();
}
