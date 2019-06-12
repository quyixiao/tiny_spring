package com.mybatis;

import com.alibaba.fastjson.JSON;
import com.mybatis.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test/mybatis/mybatis-spring.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.getUser(1l);
        System.out.println(JSON.toJSONString(user));

    }
}
