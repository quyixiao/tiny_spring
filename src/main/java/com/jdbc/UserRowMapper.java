package com.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User person = new User();
        person.setId(rs.getLong("id"));
        person.setUserName(rs.getString("user_name"));
        person.setPassword(rs.getString("password"));
        return person;
    }
}
