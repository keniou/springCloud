package com.hfc.config;

import com.hfc.service.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfeichang.
 * @date 2019/8/16 0016.
 */
@Configuration
public class UserConfigure {

    @Bean
    User user01() {
        return new User("a","10");
    }

    @Bean
    @Qualifier
    User user02() {
        return new User("b","20");
    }
}
