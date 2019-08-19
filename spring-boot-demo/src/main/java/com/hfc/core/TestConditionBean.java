package com.hfc.core;

import com.hfc.config.UserProperties;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
public class TestConditionBean {
    private UserProperties userProperties;

    public TestConditionBean() {
    }

    public TestConditionBean(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public void getName() {
        System.err.println("can auto");
    }
}
