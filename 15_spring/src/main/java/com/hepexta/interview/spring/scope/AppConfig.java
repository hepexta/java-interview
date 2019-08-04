package com.hepexta.interview.spring.scope;

import com.hepexta.interview.spring.scope.prototype.PrototypeBean;
import com.hepexta.interview.spring.scope.singletone.SingletonAppContextBean;
import com.hepexta.interview.spring.scope.singletone.SingletonBean;
import com.hepexta.interview.spring.scope.singletone.SingletonObjectFactoryBean;
import com.hepexta.interview.spring.scope.singletone.SingletonProviderBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.hepexta.interview.spring.scope")
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    public SingletonProviderBean singletonProviderBean() {
        return new SingletonProviderBean();
    }

    @Bean
    public SingletonAppContextBean singletonAppContextBean() {
        return new SingletonAppContextBean();
    }

    @Bean
    public SingletonObjectFactoryBean singletonObjectFactoryBean() {
        return new SingletonObjectFactoryBean();
    }
}
