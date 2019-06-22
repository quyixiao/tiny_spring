package com.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("RMIClient.xml");
        HelloRMIService hms = applicationContext.getBean("myClient", HelloRMIService.class);
        System.out.println(hms.getAdd(1, 2));
    }
}
