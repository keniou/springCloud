package com.hfc.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfeichang.
 * @date 2019/8/23 0023.
 */
@Configuration
public class FeignLevelConfiguration {
    /**
     * feign的日志
     * @return
     */
    @Bean
    public Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
