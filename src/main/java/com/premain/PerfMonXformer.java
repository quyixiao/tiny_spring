package com.premain;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class PerfMonXformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte [] transformed = null;
        System.out.println("Transforming " + className);
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;

        try {
            cl = pool.makeClass(new java.io.ByteArrayInputStream(classfileBuffer));
            if(cl.isInterface() == false){
                CtBehavior [] methods = cl.getDeclaredMethods();
                for(int i = 0;i < methods.length ;i ++){
                    if(methods[i].isEmpty() == false){
                        //修改 method 字节码

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }



    private void doMethod(CtBehavior method) throws NotFoundException, CannotCompileException{
        method.insertBefore("long time = System.nanoTime();");
        method.insertAfter("System.out.println(\"leave   \" + " + method.getName() +"+\"  and time:\"+(System.nanoTime() - time ));");
    }

    public static void main(String[] args) {
        String a = "System.out.println(\"leave   \" + " + "test :  " +"+\"  and time:\"+(System.nanoTime() - time ));";
        long time = System.currentTimeMillis();
        System.out.println("leave   " + "test : "+ "+"+"  and time:"+(System.nanoTime() - time ));
        System.out.println(a);
    }
}
