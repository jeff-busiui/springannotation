package com.atguigu.springannotation.annotationbo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author sunbaojin
 * @date 2020/5/7 13:22
 */
public  class CarInitializingBean  {
    private String carName;

    /**
     * 初始化
     */
    @PostConstruct
    public void postInit(){
        System.out.println(" ========================== PostConstruct ");
    }

    /**
     * 初始化
     */
    @PreDestroy
    public void PreDestroy(){
        System.out.println(" ========================== PreDestroy ");
    }
}
