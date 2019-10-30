package com.hfc.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfeichang.
 * @date 2019/8/22 0022.
 */
@Configuration
public class FeignRetryerConfiguration {

    /**
     * 在配置了ribbon的超时时间到后，在加5s执行一次重试，执行1次，本身一次算一次
     *
     * 2019-08-22 15:44:03.092  INFO 14136 --- [nio-1002-exec-6] com.hfc.controller.HelloTest             : 请求成功
     * 2019-08-22 15:44:18.108  INFO 14136 --- [nio-1002-exec-7] com.hfc.controller.HelloTest             : 请求成功
     * 超时时间配置10s
     * @return
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(2000, 2000, 3);
    }
}
