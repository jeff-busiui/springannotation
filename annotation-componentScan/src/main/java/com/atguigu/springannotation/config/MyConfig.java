package com.atguigu.springannotation.config;

import com.atguigu.springannotation.dao.childrenDao.MyChildrenDao;
import com.atguigu.springannotation.domain.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunbaojin
 * @date 2020/5/5 9:46
 */
@Configuration
// 扫描com.atguigu.springannotation.controller下的所有包
//@ComponentScan("com.atguigu.springannotation.controller")
//// 扫描多个包
//@ComponentScan(basePackages =  {"com.atguigu.springannotation.service"})
//// 根据class类扫描当前包及其子包
//@ComponentScan(basePackageClasses = {TestHelloDao.class})
//includeFilters 包括 扫描 :
//  ANNOTATION 根据注解扫描
@ComponentScan(value = "com.atguigu", includeFilters =
        {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
        }, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyChildrenDao.class})
}
)
public class MyConfig {

    @Bean
    public Persion myPersion() {
        return new Persion("lisi", 18l);
    }
}
