package com.atguigu.springannotation.aop;

/**
 * @author sunbaojin
 * @date 2020/5/8 21:58
 */
public class MathDiv {

    public void testMethod(int a, int b) {
        int c = a / b;
        System.out.println("========hello i/j ====" + c);
    }
}
