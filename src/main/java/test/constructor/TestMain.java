package test.constructor;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.replacemethod.TestChangeMethod;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("test/constructor/constructorTest.xml");
        HelloBean test =(HelloBean) bf.getBean("helloBean");
        System.out.println(JSON.toJSONString(test));
    }
}
