package com.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {


    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("RMIService.xml");
    }

}
