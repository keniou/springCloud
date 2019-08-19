package com.hfc.service;

import lombok.Data;

/**
 * @author huangfeichang.
 * @date 2019/8/16 0016.
 */
@Data
public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
