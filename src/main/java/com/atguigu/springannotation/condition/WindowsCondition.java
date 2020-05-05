package com.atguigu.springannotation.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * linux的条件判断
 * @author sunbaojin
 * @date 2020/5/5 11:54
 */
@Slf4j
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取上下文的环境变量
        Environment environment = context.getEnvironment();
        // 获取bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 获取操作信息
        String osName = environment.getProperty("os.name");
        log.info(osName);
        if(osName.toUpperCase().contains("windows".toUpperCase())){
            log.info("=======我是windows");
            return true;
        }
        return false;
    }
}
