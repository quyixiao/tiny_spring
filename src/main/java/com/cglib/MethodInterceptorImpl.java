package com.cglib;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodInterceptorImpl implements org.springframework.cglib.proxy.MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke " + method);
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("after invoke " + method);
        return result;
    }
}
