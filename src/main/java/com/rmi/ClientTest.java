package com.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// 通过这个步骤，实现了没这工端的代码的调用，你会看到测试端通过RMI进行了远程连接，连接到服务端，并使用对应的实现类HelloRMIServiceImpl
// 提供的方法add来计算参数并返回结果，你会看到控制台输出了3，当然以上的测试用例是使用同一台机器不同的端口来模拟不同的机器的RMI连接，
// 在企业应用中一般都使用不同的机器来进行RMI服务的发布与访问，你需要将接口打包，并放置在服务端工程中
// 这是一个简单的方法展示，但是却很好的展示了Spring使用中的RMI的流程以及步骤，如果抛弃了Spring，而使用原始的RMI发布与连接，则是一个麻烦的
// 事情，有兴趣的读者可以查阅读相关的资料，在Spring中使用RMI非常的简单，Spring帮我们做了大量的工作，这些工作都包括什么呢，下面，我们可以
// 深入分析Spring对RMI功能实现原理

public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("RMIClient.xml");
        HelloRMIService hms = applicationContext.getBean("myClient", HelloRMIService.class);
        System.out.println(hms.getAdd(1, 2));
    }
}
