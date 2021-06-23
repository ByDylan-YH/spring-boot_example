package com.bilibili.f_jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author:BYDylan
 * Date:2021/6/23
 * Description:
 */
@Data
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private String password;
    private int age;
}
