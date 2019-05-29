package com.test;

import com.test.dto.MyTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestCr {


    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean bean =(MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println(bean.getTestStr());
    }

}
