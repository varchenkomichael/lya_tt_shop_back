package com.varchenko.ttshop.service;

import com.varchenko.ttshop.model.User;
import com.varchenko.ttshop.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DataBaseDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DataBaseDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username:" + StringUtils.SPACE + username +
                    StringUtils.SPACE + "doesn't exist");
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(userRepository.getRole(username).getRoleName())));
    }
}
