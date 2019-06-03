package com.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {


    @Test
    public void testMain() throws Throwable {
        System.out.println("quyixiao");
    }


    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("test-construct.xml");
        } catch (Exception e) {
            e.printStackTrace();
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }

    }


    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByPrototype() throws Throwable {
        try {
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("test-prototype.xml");
            System.out.println(classPathXmlApplicationContext.getBean("circleA"));
        } catch (Exception e) {
            e.printStackTrace();
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }
}
