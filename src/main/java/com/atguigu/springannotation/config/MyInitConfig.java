package com.atguigu.springannotation.config;

import com.atguigu.springannotation.annotationbo.CarInitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunbaojin
 * @date 2020/5/7 13:25
 */
@Configuration
public class MyInitConfig {

    @Bean
    public CarInitializingBean getCar(){
        return new CarInitializingBean();
    }

}
