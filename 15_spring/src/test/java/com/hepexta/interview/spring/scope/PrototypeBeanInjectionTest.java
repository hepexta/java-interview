package com.hepexta.interview.spring.scope;

import com.hepexta.interview.spring.scope.prototype.PrototypeBean;
import com.hepexta.interview.spring.scope.singletone.SingletonAppContextBean;
import com.hepexta.interview.spring.scope.singletone.SingletonBean;
import com.hepexta.interview.spring.scope.singletone.SingletonLookupBean;
import com.hepexta.interview.spring.scope.singletone.SingletonObjectFactoryBean;
import com.hepexta.interview.spring.scope.singletone.SingletonProviderBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = AppConfig.class)
public class PrototypeBeanInjectionTest {

    @Test
    public void givenPrototypeInjection_WhenObjectFactory_ThenNewInstanceReturn() {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonObjectFactoryBean firstContext = context.getBean(SingletonObjectFactoryBean.class);
        SingletonObjectFactoryBean secondContext = context.getBean(SingletonObjectFactoryBean.class);
        PrototypeBean firstInstance = firstContext.getPrototypeInstance();
        PrototypeBean secondInstance = secondContext.getPrototypeInstance();

        Assert.assertTrue("New instance expected", firstInstance != secondInstance);
    }

    @Test
    public void givenPrototypeInjection_WhenLookup_ThenNewInstanceReturn() {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonLookupBean firstContext = context.getBean(SingletonLookupBean.class);
        SingletonLookupBean secondContext = context.getBean(SingletonLookupBean.class);

        PrototypeBean firstInstance = firstContext.getPrototypeBean();
        PrototypeBean secondInstance = secondContext.getPrototypeBean();

        Assert.assertTrue("New instance expected", firstInstance != secondInstance);
    }

    @Test
    public void givenPrototypeInjection_WhenProvider_ThenNewInstanceReturn() {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonProviderBean firstContext = context.getBean(SingletonProviderBean.class);
        SingletonProviderBean secondContext = context.getBean(SingletonProviderBean.class);
        PrototypeBean firstInstance = firstContext.getPrototypeInstance();
        PrototypeBean secondInstance = secondContext.getPrototypeInstance();

        Assert.assertTrue("New instance expected", firstInstance != secondInstance);
    }

    @Autowired
    SingletonProviderBean singletonProviderBean;
    @Autowired
    SingletonAppContextBean singletonAppContextBean;
    @Autowired
    SingletonBean singletonBean;
    @Autowired
    SingletonBean singletonBean1;

    @Test
    public void givenPrototypeInjection_WhenCall_ThenSameInstance() {

        PrototypeBean prototypeBean = singletonBean.getPrototypeBean();
        PrototypeBean prototypeBean1 = singletonBean.getPrototypeBean();

        Assert.assertFalse("New instance expected", prototypeBean != prototypeBean1);

        PrototypeBean prototypeBean2 = singletonBean.getPrototypeBean();
        PrototypeBean prototypeBean3 = singletonBean1.getPrototypeBean();

        Assert.assertFalse("New instance expected", prototypeBean2 != prototypeBean3);

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingletonBean firstContext = context.getBean(SingletonBean.class);
        SingletonBean secondContext = context.getBean(SingletonBean.class);

        Assert.assertFalse("New instance expected", firstContext != secondContext);
    }

    @Test
    public void givenPrototypeInjection_WhenCall_ThenNewInstance() {

        PrototypeBean firstInstance = singletonProviderBean.getPrototypeInstance();
        PrototypeBean secondInstance = singletonProviderBean.getPrototypeInstance();

        Assert.assertTrue("New instance expected", firstInstance != secondInstance);

        PrototypeBean prototypeBeanApp = singletonAppContextBean.getPrototypeBean();
        PrototypeBean prototypeBeanApp1 = singletonAppContextBean.getPrototypeBean();

        Assert.assertTrue("New instance expected", prototypeBeanApp != prototypeBeanApp1);
    }
}
