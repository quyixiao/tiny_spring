package com.obscenity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> obscenties;

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenties = new HashSet<>();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {
                    System.out.println("==============" + strVal + " result = " + isObscene(strVal));
                    if (isObscene(strVal)) {
                        return "*******";
                    }
                    return strVal;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }

    }

    public boolean isObscene(Object value) {
        for(String a : obscenties){
            System.out.print(a +",");
        }
        String protentialObscenity = value.toString().toUpperCase();
        return this.obscenties.contains(protentialObscenity);
    }


    public void setObscenties(Set<String> obscenties) {
        this.obscenties.clear();
        for (String o : obscenties) {
            this.obscenties.add(o.toUpperCase());
        }
    }

}
