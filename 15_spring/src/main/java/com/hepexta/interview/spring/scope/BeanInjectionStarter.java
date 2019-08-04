package com.hepexta.interview.spring.scope;

import com.hepexta.interview.spring.scope.prototype.PrototypeBean;
import com.hepexta.interview.spring.scope.singletone.SingletonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class BeanInjectionStarter {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstPrototype.equals(secondPrototype), "The same instance is returned");

    }
}
