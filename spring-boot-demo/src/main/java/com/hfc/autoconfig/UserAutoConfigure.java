package com.hfc.autoconfig;

import com.hfc.config.UserProperties;
import com.hfc.core.TestConditionBean;
import com.hfc.core.UserClient;
import com.hfc.service.TestUser;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@Configuration
@ConditionalOnClass(TestConditionBean.class)
@EnableConfigurationProperties({UserProperties.class})
public class UserAutoConfigure {

    @Bean
    @ConditionalOnProperty(prefix = "spring.user", value = "enable", havingValue = "true")
    public UserClient userClient(UserProperties userProperties) {
        return new UserClient(userProperties);
    }

    /**
     * 对接口的方法的重写
     * @return
     */
    @Bean
    public TestUser testUser() {
        return sd -> {};
    }
}
