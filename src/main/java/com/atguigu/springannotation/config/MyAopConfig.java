package com.atguigu.springannotation.config;

import com.atguigu.springannotation.aop.MathAspects;
import com.atguigu.springannotation.aop.MathDiv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author sunbaojin
 * @date 2020/5/8 22:14
 */
@EnableAspectJAutoProxy // 开启注解代理
@Configuration
public class MyAopConfig {

    @Bean("getMathDiv")
    public MathDiv getMathDiv(){
        return new MathDiv();
    }

    @Bean("getMathAspects")
    public MathAspects getMathAspects(){
        return new MathAspects();
    }
}
