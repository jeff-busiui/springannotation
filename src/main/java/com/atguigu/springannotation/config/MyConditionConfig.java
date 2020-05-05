package com.atguigu.springannotation.config;

import com.atguigu.springannotation.condition.LinuxCondition;
import com.atguigu.springannotation.condition.WindowsCondition;
import com.atguigu.springannotation.domain.Persion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author sunbaojin
 * @date 2020/5/5 11:54
 */
@Configuration
@Slf4j
public class MyConditionConfig {

    /**
     * scope  单例
     * @return
     */
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean("condition_kk1")
    @Conditional(value = {LinuxCondition.class})
    public Persion getPersion(){
        log.info("getPersion");
        return new Persion("张三1",18);
    }

    /**
     * scope  单例
     * @return
     */
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean("condition_kk2")
    @Conditional(value = {WindowsCondition.class})
    public Persion getPersion2(){
        log.info("getPersion");
        return new Persion("张三2",20);
    }
}
