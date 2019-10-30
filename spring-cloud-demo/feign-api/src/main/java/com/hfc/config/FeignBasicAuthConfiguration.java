package com.hfc.config;

import com.hfc.interceptor.FeignBasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfeichang.
 * @date 2019/8/23 0023.
 */
@Configuration
public class FeignBasicAuthConfiguration {

    @Bean
    public FeignBasicAuthRequestInterceptor feignBasicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }
}
