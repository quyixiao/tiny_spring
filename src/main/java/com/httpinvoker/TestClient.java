package com.httpinvoker;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-client.xml");
        HttpInvokeTestI httpInvokeTestI = (HttpInvokeTestI)context.getBean("remoteService");
        System.out.println(httpInvokeTestI.getTestPo("dddddddd"));
    }
}
