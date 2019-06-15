package com.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements org.springframework.jdbc.core.RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User person = new User(rs.getLong("id"),
                rs.getString("user_name"),
                rs.getString("password"));
        return null;
    }
}
