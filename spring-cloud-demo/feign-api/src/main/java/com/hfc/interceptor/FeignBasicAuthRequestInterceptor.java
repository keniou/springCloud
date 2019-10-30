package com.hfc.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author huangfeichang.
 * @date 2019/8/23 0023.
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.err.println("进入自定义配置认证");
    }
}
