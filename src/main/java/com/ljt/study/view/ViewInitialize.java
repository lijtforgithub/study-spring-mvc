package com.ljt.study.view;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author LiJingTang
 * @date 2021-08-15 12:42
 */
@Component
public class ViewInitialize implements ApplicationContextAware, InitializingBean, DisposableBean {

    @Override
    public void destroy() {
        System.out.println("ViewInitialize: destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("ViewInitialize: afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ViewInitialize: setApplicationContext");
    }

}
