package com.premain;


/***
 * java 选项中有-javaagent:xx，其中 xx 就是你的 agent JAR ，java 通过选项加载agent ，由 agent 来监控 classpath 下的应用
 * 由执行结果可以看出，执行顺序以通过改变 org.toy.App ，的字节码加入监控代码确实生效了，你也可以发现，通过 Instrment 实现
 * agent 使得监控代码完全隔离了
 * 通过之前的两个小示例，我们似乎已经有所体会了，在 Spring 中静态 AOP 直接使用了 AspectJ 提供了方法，而 AspectJ 又是在 Instrument
 * 基础上进行封装的，就以上面的这个例子来看至少在  AspectJ 中会如下功能
 * 1.读取 META-INF/aop.xml
 * 2.将 aop.xml 中定义的增强器通过自定义的 ClassFileTransformer 织入 对应的类中
 * 当然这都是 AspectJ 所做的事情 ，并不在我们讨论的范畴，Spring 是直接使用 AspectJ，也就是将动态代理的任务直接委托给了 AspectJ，那么
 * ，Spring 怎样嵌入的叱，同样我们还是从配置文件入手
 *
 */
public class App {

    public static void main(String[] args) {
        new App().test();
    }

    public void test(){
        System.out.println("Hello World ! ");
    }
}
