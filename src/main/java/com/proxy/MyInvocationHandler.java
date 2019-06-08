package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {


    //目标方法
    private Object target;


    /***
     * 构造方法
     * @param target 目标对象
     */
    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("---------------before---------------------------");
        //执行目标对象方法
        Object result = method.invoke(target,args);
        // 在目标对象方法执行之后简单的打印一下
        System.out.println("-----------------after----------------------------------");
        return result;
    }


    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);

    }
}
