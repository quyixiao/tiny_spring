package com.premain;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;




public class PerfMonAgent {



    static private Instrumentation inst = null;

    /***
     * This method is called before the applications main-method is called
     * when this agent is spcecified to the Java VM
     */
    public static void premain(String agentArgs,Instrumentation _inst){
        System.out.println("PerfMonAgent.premain() was called ");
        // Initialize the static variables we use to track infomation
        inst = _inst;
        // Set up the class-file trasformer
        ClassFileTransformer transformer = new PerfMonXformer() ;
        System.out.println("Adding a PerfMonXformer instance to the JVM");
        inst.addTransformer(transformer);
        // 上面两个类就是 agent 的核心了，JVM 启动时在应用加载前会调用 PerMonAgent.premain 然后 PerfMonAgent.premain 中实例化了
        // 一个定制的 ClassFileTransforme，即 PerfMonXformer 并通过 inst.addTransformer(trans) 把 PerfMonXformer.transform 都
        // 被调用了，你在此方法中以改变加载的类，真的有点神奇了，为了改变类的字节码，我们使用了 JBoss 的 javassist，虽然你不一定要这么
        // 用，但是 JBoss 的 javassist 真的很强大，能让你很容易的改变类的字节码，在上面的方法中我们通过改变类的字节码，在每个类的方法
        // 中加入了 long time = System.nanoTime(); 在方法的出口加入了
        // System.println("methodClassName.methodName:" + (System.nanoTime()-startTime))

        // 3 打包 agent
        // 对于 agent 的打包，有点讲究的
        // JAR 的 META-INF/MANIFEST.MF 加入 Premain-Class:xx ，xx 表示在此语境中是我们的 agent 类，即 org.toy.perfMonAgent
        // 如果你的 agent 类引入别的包，需要使用 Boot-Class-Path :xx,xx 在此语境中就是上面反映到了 JBoss.javassit ，即 /home/pwlaxy/.m2/repository/javassist/javassit/3.8.0.GA/javassist-3.8.0.GA.jar
        //下面附上 Mavan 的 POM
        //

        /***
         * <configuration>
         *     <archive>
         *      <mainfestEntries>
         *          <Premain-Class>org.toy.PerfMainAgent</Premain-Class>
         *          <Boot-class-Path>/home/pwlazy/.m2/repository/javassist/3.8.0.GA/javassaget-3.8.0.GA.jar</Boot-class-Path>
         *      </mainfestEntries>
         *     </archive>
         * </configuration>
         */
    }
}
