package com.varchenko.ttshop.repository;

import com.varchenko.ttshop.model.Role;
import com.varchenko.ttshop.model.User;

public interface UserRepository {

    void addUser(User user);
    User findUserByUsername(String username);
    int deleteUser(String username);
    Role getRole(String username);
}
