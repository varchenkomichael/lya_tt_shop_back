package com.varchenko.ttshop.mapper;

import com.varchenko.ttshop.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    private final User user;

    public UserMapper(User user) {
        this.user = user;
    }

    public UserMapper() {
        this.user = new User();
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        user.setId(rs.getInt("user_id"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
