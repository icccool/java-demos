package com.demos.spring;

import org.springframework.context.ApplicationContext;

/**
 * @Author WANG JI BO
 * @Date 2019/8/29 下午9:07
 * @Description
 **/
public class SpringDemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = null;
        context.getAutowireCapableBeanFactory().autowireBean(new Object());
    }
}
