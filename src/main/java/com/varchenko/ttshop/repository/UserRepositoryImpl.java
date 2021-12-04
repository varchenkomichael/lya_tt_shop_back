package com.varchenko.ttshop.repository;

import com.varchenko.ttshop.mapper.RoleMapper;
import com.varchenko.ttshop.mapper.UserMapper;
import com.varchenko.ttshop.model.Role;
import com.varchenko.ttshop.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String ADD_USER_SQL = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_USERNAME = "SELECT * FROM user WHERE username = ?";
    private static final String DELETE_USER = "DELETE FROM user WHERE username = ?";
    private static final String GET_USER_ROLE = "SELECT username FROM user " +
            "INNER JOIN user_role ur on \"user\".user_id = ur.user_id " +
            "INNER JOIN roles r on r.roles_id = ur.role_id WHERE username = ?";
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.query(ADD_USER_SQL, new UserMapper(user));
    }

    @Override
    public User findUserByUsername(String username) {
        return jdbcTemplate.query(GET_USER_BY_USERNAME, new UserMapper(), new Object[]{username}).get(0);
    }

    @Override
    public int deleteUser(String username) {
        return jdbcTemplate.update(DELETE_USER, username);
    }

    @Override
    public Role getRole(String username) {
        return jdbcTemplate.query(GET_USER_ROLE, new RoleMapper(), new Object[]{username}).get(0);
    }
}
