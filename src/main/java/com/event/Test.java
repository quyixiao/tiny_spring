package com.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans4.xml");
        TestEvent event = new TestEvent("hello","msg");
        context.publishEvent(event);
    }
}
