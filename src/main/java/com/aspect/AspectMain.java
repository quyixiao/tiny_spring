package com.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/***
 * Spring 中摒弃了最原始的繁杂的配置方式，而是采用@AspectJ 注解 POJO 进行标注，使得 AOP 的工作大大简化，
 * 例如，在 AspectJTest类中，我们要做的就是所有的类的 test()方法执行前在控制台中打印 beforeTest，而在所有的的
 * 类的 test方法执行后打印 afterTest，同时又使用环绕的方式在所有的类的方法执行前后再次打印 before1和 after1
 *
 *
 *
 * Spring 实现了对所有的类的 test 方法进行增强，使用辅助功能可以独立于核心业务之外 ，方便与程序的扩展和解耦。
 * 那么，Spring 究竟是如何实现 AOP 的呢，首先我们知道，Spring 是否支持注解AOP 是由一个配置文件控制，也就是说<aop:aspectj-autoproxy></aop>
 * ，当配置文件中声明了这句配置时候，Spring 就会支持注解 AOP ，那么我们分析就从这个注解开始
 *
 */
public class AspectMain {


    /***
     * before1
     beforeTest
     test
     after1
     afterTest
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aspect.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();

    }
}
