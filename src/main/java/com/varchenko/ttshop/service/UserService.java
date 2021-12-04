package com.varchenko.ttshop.service;

import com.varchenko.ttshop.model.User;

public interface UserService {

    void createUser(User user);

    User findUserByUsername(String username);

    int deleteUser(String username);
}
