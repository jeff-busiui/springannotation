package com.atguigu.springannotation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunbaojin
 * @date 2020/5/5 9:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persion {
    private String userName;
    private int age;
}
