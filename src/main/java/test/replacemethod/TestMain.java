package test.replacemethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("test/replacemethod/replaceMethodTest.xml");
        TestChangeMethod test =(TestChangeMethod) bf.getBean("testChangeMethod");
        test.changeMe();
    }
}
