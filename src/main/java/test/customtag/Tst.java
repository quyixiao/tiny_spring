package test.customtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Tst {
    public static void main(String[] args) {
        ApplicationContext beans = new ClassPathXmlApplicationContext("classpath:test.xml");
        User user = (User) beans.getBean("testbean");
        System.out.println("username:" + user.getUserName() + "  " + "email:" + user.getEmail());
    }
}