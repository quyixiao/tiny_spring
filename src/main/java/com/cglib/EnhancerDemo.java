package com.cglib;

import org.springframework.cglib.proxy.Enhancer;

/****
 * 我们可以看到，System.out.println(demo),demo 首先调用了 toString()方法，然后调用了hashCode方法，生成的对象为
 * com.cglib.EnhancerDemo$$EnhancerByCGLIB$$f926c6f4@5e265ba4 的实例，这个类的运行是由 CGLIB 产生的
 *
 * 完成了 CGLIB 代理的类是委托给了 Cglib2AopProxy类去实现，我们进入了类一探究竟，按照之前提供的示例，我们容易判断出来，CGLIB2AOPProxy
 * 是入口应该是在 getProxy，也是我们据说听 CBLib2AOPProxy 类 getProxy 方法中实现Enhancer 的创建及接口的封装
 *
 *
 *
 *
 *
 *
 *
 */
public class EnhancerDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        EnhancerDemo demo = (EnhancerDemo) enhancer.create();

        demo.test();


        System.out.println(demo);

    }


    public void test() {
        System.out.println("EnhancerDemo test");
    }
}
