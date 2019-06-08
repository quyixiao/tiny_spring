package com.proxy;

import org.junit.Test;

public class ProxyTest {

    public static void main(String[] args) {
        // 实例目标对象
        UserService userService = new UserServiceImpl();
        //实例化 InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        //根据目标对象生成代理对象
        UserService proxy = (UserService)invocationHandler.getProxy();
        //调用代理对象方法
        proxy.add();

    }
}
