package com.hfc.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2019-08-23 13:59:02.255  INFO 4516 --- [io-1002-exec-10] com.hfc.controller.HelloTest             : 请求成功get
 * 2019-08-23 13:59:07.272  INFO 4516 --- [nio-1002-exec-3] com.hfc.controller.HelloTest             : 请求成功get
 * @author huangfeichang.
 * @date 2019/8/23 0023.
 */
@Configuration
public class feignOvertimeConfiguration {

    @Bean
    public Request.Options options() {
        return new Request.Options(2000, 3000);
    }
}
