package com.atguigu;

import com.atguigu.springannotation.aop.MathDiv;
import com.atguigu.springannotation.config.*;
import com.atguigu.springannotation.domain.Persion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

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
        printAllBeanName(annotationConfigApplicationContext);
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

    }

    @Test
    public void testInit(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyInitConfig.class);
        printNameByBeanClass(annotationConfigApplicationContext,Persion.class);

        annotationConfigApplicationContext.close();

    }

    public  void printNameByBeanClass(AnnotationConfigApplicationContext annotationConfigApplicationContext,Class classBean){
        // 获取扫描的所有类
        // 获取扫描的所有类
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanFactory().getBeanNamesForType(classBean);
        // 遍历
        for (int i=0; i< beanDefinitionNames.length; i++ ) {
            // 只打印为自己的
            log.info("====="+beanDefinitionNames[i]);
        }
    }

    public  void printAllBeanName(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        // 获取扫描的所有类
        // 获取扫描的所有类
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        // 遍历
        for (int i=0; i< beanDefinitionNames.length; i++ ) {
            // 只打印为自己的
            log.info("====="+beanDefinitionNames[i]);
        }
    }


    @Test
    public  void testAop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MyAopConfig.class);
        applicationContext.refresh();
        printAllBeanName(applicationContext);
        // 获取bean
        MathDiv bean = (MathDiv) applicationContext.getBean("getMathDiv");
        // 调用除法
        bean.testMethod(1,2);

        // 调用除法
        bean.testMethod(1,0);
//        System.out.println(bean);
    }

    @Test
    public void testAssert(){
        Assert.isTrue(false,"我错了");
//        Assert.hasLength();
        Persion persion =new Persion();

    }

}
