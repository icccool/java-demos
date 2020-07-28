package com.demos.spring.context.autowirebean;

import org.springframework.context.ApplicationContext;


/***
 * 注入自己的bean
 */
public class AutowireBean {
    public static void main(String[] args) {
        ApplicationContext context = null;
        context.getAutowireCapableBeanFactory().autowireBean(new Object());
    }
}
