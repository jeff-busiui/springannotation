package com.atguigu;

import com.atguigu.springannotation.config.MyComponentScanConfig;
import com.atguigu.springannotation.config.MyConditionConfig;
import com.atguigu.springannotation.config.MyScopeConfig;
import com.atguigu.springannotation.domain.Persion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;

/**
 * @author sunbaojin
 * @date 2020/5/5 9:43
 */
@Slf4j
public class TestAll {

    @Test
    public void testComponentScan(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyComponentScanConfig.class);
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

    @Test
    public void testScope(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyScopeConfig.class);
        // 获取扫描的所有类
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanFactory().getBeanNamesForType(Persion.class);
        // 遍历
        for (int i=0; i< beanDefinitionNames.length; i++ ) {
            // 只打印为自己的
            log.info("====="+beanDefinitionNames[i]);
        }
        // scope 作用域，默认单例，获取kk对象
        Object kk1_1 = annotationConfigApplicationContext.getBean("kk_1");
        Object kk1_2 = annotationConfigApplicationContext.getBean("kk_1");
        System.out.println(kk1_1 == kk1_2);

        // scope 作用域，多例，获取kk对象
        Object kk2_1 = annotationConfigApplicationContext.getBean("kk_2");
        Object kk2_2 = annotationConfigApplicationContext.getBean("kk_2");
        System.out.println(kk2_1 == kk2_2);

        // scope 作用域，单例，懒汉
        Object kk3_1 = annotationConfigApplicationContext.getBean("kk_3");
        Object kk3_2 = annotationConfigApplicationContext.getBean("kk_3");
        System.out.println(kk3_1 == kk3_2);
    }

    @Test
    public void testCondition(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyConditionConfig.class);
        // 获取扫描的所有类
        // 获取扫描的所有类
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanFactory().getBeanNamesForType(Persion.class);
        // 遍历
        for (int i=0; i< beanDefinitionNames.length; i++ ) {
            // 只打印为自己的
            log.info("====="+beanDefinitionNames[i]);
        }
    }


}
