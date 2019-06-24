package com.message;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Java消息服务，应用程序接口是一个 java 平台中关于面向消息中间件（MOM） 的 API,用于两个应用程序之间的或分布式系统中发送消息
 * ，进行异步通信，java 消息服务是一个与具体的平台无关的 API,绝大多数 MOM 提供商对 JMS 提供了支持
 * Java 消息服务的规范包括两种消息的模式，点对点和发布/订阅者，许多的提供商支持这一通用框架，因此，程序员可以在他们的分布式
 * 软件中实现面对面的消息的操作，这些操作将具有不同的面向消息中间件的产品的可移植性
 *
 * Java 消息服务支持同步和异步的消息处理，在某些场景下，异步消息是必要的，而且比同步消息操作更加便利
 * Java 消息服务支持面向事件的方法接收消息，事件驱动的程序设计现在被广泛的认为是一种富有成效的程序设计范例，
 * 程序员们都相当的熟悉
 * 在应用系统开发时，java 消息服务可以推迟选择面对消息中间件的产品，也可以在不同的面向对消息中间件切换
 * 本章以 java 消息服务的 服务可以推迟选择面对消息中间件产品，也可以在不同的页面对消息中间件切换
 * 本章以 Java 消息服务的开源实现产品，ActiveMQ 为例进行 Spring 整合消息服务功能的实现分析
 *
 * JMS 的独立使用
 * 尽管大多数的 Java 消息服务的使用会跟 Spring 相结合，但是，我们还是非常有必要的了解消息的独立的使用方法，这对于我们了解消息
 * 的实现原理以及后续的与 Spring 整合实现分析都非常的重要，当然在消息服务的使用前，需要我们先开启消息服务器，如果是 Windows 系统下
 * 可以直接双击 ActiveMQ 安装目录下的 bin 目录的 activeMq.bat 文件来启动消息服务器，
 * 消息服务的使用除了要开启消息服务器外，还需要构建消息的发送端与接收端，发送端主要用来将包含业务逻辑的消息发送到消息服务器，
 * 而消息接收端则用于服务器中的消息提取并进行相应的处理
 *
 *
 * Spring 整合 ActiveMQ
 * 整个消息的发送与推送服务过程非常的简单，但是其中却参杂大量的冗余的代码，比如 Connection 的创建与关闭，Session 的创建与关闭，为了消除
 * 这一冗余的工作量，Spring 进行了进一步的封装，Spring 下的 ActiveMQ使用方式如下
 * 1.Spring 配置文件
 * 配置文件是 Spring 的核心，Spring 整合消息服务的使用也是从配置文件中配置开始的，类似于数据库的操作，Spring 也将 ActiveMQ 中的操作
 * 统一封装至 JMSTemplate 中，以方便我们统一使用，所在在 Spring 中的核心配置文件首先注册 JMSTemplate 类型的 Bean,当然，ActiviMQConnectionFactory
 * 用于连接消息服务器，是消息服务的基础，也要注册 ActiveMQQueue 则助于指定消息的目的地
 *
 *
 *
 *
 *
 *
 *
 */
public class Sender {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        javax.jms.Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        MessageProducer producer = session.createProducer(destination);
        for(int i = 0;i < 3 ;i++){
            TextMessage message = session.createTextMessage("大家好，我是测试");
            Thread.sleep(1000);
            System.out.println("send:"+message);
            producer.send(message);
        }
        session.commit();
        session.close();
        connection.close();
    }
}
