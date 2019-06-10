package com.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserSerivce {

    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO lsd_user ( user_name, password) VALUES  ( ?,?) ",
                new Object[]{user.getUserName(), user.getPassword()},
                new int[]{Types.VARCHAR, Types.VARCHAR});
    }

    @Override
    public List<User> getUsers() {
        List<User> list = jdbcTemplate.query("select * from lsd_user limit 10 ", new UserRowMapper());

        return list;
    }
}
