package test.lookup.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("test/lookup/lookupTest.xml");
        GetBeanTest getBeanTest = (GetBeanTest)bf.getBean("getBeanTest");
        getBeanTest.showMe();
    }
}
