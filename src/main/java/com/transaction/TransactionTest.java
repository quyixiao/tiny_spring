package com.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans8.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        userService.save(user);
    }
}
