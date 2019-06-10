package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJDBCTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans6.xml");
        UserSerivce userService = (UserSerivce) applicationContext.getBean("userSerivce");
        User user = new User();
        user.setPassword("quyixiao");
        user.setUserName("ZH");
        //userService.save(user);


        List<User> person1 = userService.getUsers();
        for (User user1 : person1) {
            System.out.println("userName:" + user1.getUserName() + ",password:" + user1.getPassword());

        }
    }
}
