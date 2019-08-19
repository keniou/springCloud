package com.hfc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@Data
@ConfigurationProperties(prefix = "spring.user")
public class UserProperties {
    private String name;
}
