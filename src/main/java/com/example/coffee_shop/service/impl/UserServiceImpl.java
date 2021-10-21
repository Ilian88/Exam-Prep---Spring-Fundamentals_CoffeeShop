package com.example.coffee_shop.service.impl;

import com.example.coffee_shop.model.entity.UserEntity;
import com.example.coffee_shop.model.service.UserLoginService;
import com.example.coffee_shop.model.service.UserRegisterService;
import com.example.coffee_shop.model.view.UserViewModel;
import com.example.coffee_shop.repository.UserRepository;
import com.example.coffee_shop.service.UserService;
import com.example.coffee_shop.util.CurrentUser;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public Boolean checkIfUserExistsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    @Override
    public Boolean checkIfUserExistsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public void saveUser(UserRegisterService userRegisterService) {

        UserEntity user = modelMapper.map(userRegisterService,UserEntity.class);

        this.userRepository.save(user);

    }

    @Override
    public boolean checkIfUserExistsByUsernameAndPassword(String username, String password) {
        return this.userRepository.existsByUsernameAndPassword(username,password);
    }

    @Override
    public void loginUser(UserLoginService userLogin) {

        UserEntity user = this.userRepository.findByUsernameAndPassword(userLogin.getUsername(),
                userLogin.getPassword());

        currentUser.setId(user.getId())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());


    }

    @Override
    public UserEntity findCurrentUser() {
        return this.userRepository.findByUsername(currentUser.getUsername());
    }

    @Override
    public List<UserViewModel> getAllEmployees() {

        return this.userRepository.findAll()
                .stream()
                .map(u -> {

                    UserViewModel userViewModel = modelMapper.map(u,UserViewModel.class);
                    userViewModel.setNumberOfOrders(u.getOrders().size());

                    return userViewModel;

                })
                .collect(Collectors.toList());


    }
}
