package com.atguigu;

import com.atguigu.springannotation.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;

/**
 * @author sunbaojin
 * @date 2020/5/5 9:43
 */
@Slf4j
public class TestHello {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        // 获取扫描的所有类
        Iterator<String> beanNamesIterator = annotationConfigApplicationContext.getBeanFactory().getBeanNamesIterator();
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanFactory().getBeanDefinitionNames();
        // 遍历
        for (Iterator<String> it = beanNamesIterator; it.hasNext(); ) {
            String beanClass = it.next();
            // 只打印为自己的
            log.info("====="+beanClass);
        }

    }
}
