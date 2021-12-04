package com.varchenko.ttshop.service;

import com.varchenko.ttshop.model.User;
import com.varchenko.ttshop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public int deleteUser(String username) {
        return userRepository.deleteUser(username);
    }
}
