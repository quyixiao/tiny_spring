package com.proxy;

// 用起来很简单，其实这个基本上就是 AOP 的一个简单的实现，在目标对象方法执行之前，和执行之后，
// 进行了增强，Spring 的 aop 实现其实也是用了 Proxy 和 InvocationHandler 这两个东西的
// 我们再次来回顾一下使用 JDK 代理方式，在整个创建过程中，对于 InvocationHandler 的创建是最为核心的，在自定义 InvocationHandler
// 中需要重写三个函数
// 构造函数，将代理对象传入
//  invoke方法，此方法中实现了AOP 增强的所有的逻辑
// getProxy方法，此方法千篇一律，但是必不可少
// 那么我们看看 Spring JDK 代理实现的是不是也是这么做的呢，继续之前的跟踪，到达 JdkDynamicAopProxy 的 getProxy

public class ProxyTest {

    public static void main(String[] args) {
        // 实例目标对象
        UserService userService = new UserServiceImpl();
        //实例化 InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        //根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();
        //调用代理对象方法
        proxy.add();

    }
}
