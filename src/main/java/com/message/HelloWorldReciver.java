package com.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.TextMessage;


// 到这里，我们已经完成了 Spring 消息的发送与接收的操作，但是如：HelloWorldReciver 中所示的代码，使用的是 J
public class HelloWorldReciver {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans-activemq.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (Destination) context.getBean("destination");
        TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
        System.out.println("reviced msg is :" + msg.getText());
    }
}
