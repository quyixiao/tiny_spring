package com.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//下面的测试示例中，UserServiceImpl类对接口中，UserServcie中的save函数的实现了最后加入了一句抛出异常的代码，
// throw new RuntimeException("aa") 当注掉这段代码执行的测试类，那么会看到数据被成功保存到数据库中，但是如果加入了这一句抛出异常的
// 代码，throw new RuntimeException("aa"); 当注掉这段代码执行测试类，那么会看到数据被保存到了数据库中，
// 但是如果加入了这段代码时再次运行测试类，发现此处的数据并不会保存到数据库中
// 注意，默认的情况下，Spring中的事务处理只对 RuntimeException方法进行回滚，所以如果 将runtimeException替换成普通的exception不会生产
// 回滚效果

// 事务自定义标签
// 对于Spring中的事务功能的代码分析，我们我准备去从配置文件开始入手，在配置文件中有这样的一个配置，<tx:annotation-driven/>
// 可以说此处配置的是事务的开关，如果没有此配置，那么Spring中将不存在事务的功能，那么我们就从这个配置开始分析
// 根据之前的分析，我们因此可以判断，在自定义标签中解析过程中一定是做了一些辅助的操作的，于是我们先从自定义标签入手进行分析
//
public class TransactionTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans8.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        userService.save(user);
    }
}
