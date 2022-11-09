package com.so.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setMyDouble(123);
        myBean.setMyLong(123);
        myBean.setMyString("my bean");
        return myBean;
    }
}
