package com;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {



    public MyClassPathXmlApplicationContext(String ... confiLocations){
        super(confiLocations);
    }


    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory){
        super.setAllowBeanDefinitionOverriding(false);
        super.setAllowCircularReferences(false);
        super.customizeBeanFactory(beanFactory);
    }

    public void initPropertySources(){
        //添加验证要求
        getEnvironment().setRequiredProperties("VAR");
    }
}
