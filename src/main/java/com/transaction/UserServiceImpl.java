package com.transaction;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;

public class UserServiceImpl implements UserService {


    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void save(User user) throws Exception {
        jdbcTemplate.update("INSERT INTO lsd_user ( user_name, password) VALUES  ( ?,?) ",
                new Object[]{user.getUserName(), user.getPassword()},
                new int[]{Types.VARCHAR, Types.VARCHAR});

        //事务测试，加上这句代码则数据不会保存到数据库中
        throw new RuntimeException("aaaaa");

    }
}
