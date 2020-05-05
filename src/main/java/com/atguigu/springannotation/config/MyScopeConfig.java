package com.atguigu.springannotation.config;

import com.atguigu.springannotation.domain.Persion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author sunbaojin
 * @date 2020/5/5 11:40
 */
@Configuration
@Slf4j
public class MyScopeConfig {

    /**
     * scope  单例
     * @return
     */
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean("kk_1")
    public Persion getPersion(){
        log.info("getPersion");
        return new Persion("kk",18);
    }

    /**
     * scope  多例
     * @return
     */
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean("kk_2")
    public Persion getPersion2(){
        log.info("getPersion2");
        return new Persion("kk",18);
    }

    /**
     * scope  单例，懒汉加载
     * @return
     */
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean("kk_3")
    @Lazy
    public Persion getPersion3(){
        log.info("getPersion3");
        return new Persion("kk",18);
    }
}
