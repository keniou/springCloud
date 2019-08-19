package com.hfc.core;

import com.hfc.config.UserProperties;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
public class UserClient {
    private UserProperties userProperties;

    public UserClient() {
    }

    public UserClient(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public void getName() {
        System.err.println(userProperties.getName());
    }
}
