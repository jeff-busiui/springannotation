package com.atguigu.springannotation.aop;

import cn.hutool.json.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 日志方法的切面类：
 *
 * @author sunbaojin
 * @Before 前置通知
 * @After 后置通知
 * @date 2020/5/8 21:49
 */
@Aspect
public class MathAspects {

    @Pointcut("execution(* com.atguigu.springannotation.aop.MathDiv.*(..))")
    public void aPointcut() {
    }

    @Before("execution(* com.atguigu.springannotation.aop.MathDiv.*(..))")
    public void testMethod1() {
        System.out.println("========hello====Before");
    }

    @After("execution(* com.atguigu.springannotation.aop.MathDiv.*(..))")
    public void testMethod2() {
        System.out.println("========hello====After");
    }

    @AfterReturning("execution(* com.atguigu.springannotation.aop.MathDiv.*(..))")
    public void testMethod3() {
        System.out.println("========hello====AfterReturning");
    }

    @AfterThrowing("execution(* com.atguigu.springannotation.aop.MathDiv.*(..))")
    public void testMethod4() {
        System.out.println("========hello====AfterThrowing");
    }

    @Around("execution(* com.atguigu.springannotation.aop.MathDiv.*(..))")
    public void testMethod5(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("========hello====Around====args:"+ JSONUtil.toJsonStr(args));
        System.out.println("========hello====Around====name:"+name);
        joinPoint.proceed();
        System.out.println("========hello====Around");
    }

}
