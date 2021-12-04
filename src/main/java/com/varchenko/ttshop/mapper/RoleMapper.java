package com.varchenko.ttshop.mapper;

import com.varchenko.ttshop.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {

    private final Role role;

    public RoleMapper(Role role) {
        this.role = role;
    }

    public RoleMapper() {
        this.role = new Role();
    }

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        role.setId(rs.getInt("roles_id"));
        role.setRoleName(rs.getString("role"));
        return role;
    }
}
