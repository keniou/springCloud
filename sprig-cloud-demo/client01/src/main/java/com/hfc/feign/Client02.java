package com.hfc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangfeichang.
 * @date 2019/8/22 0022.
 */
@FeignClient(name = "client02")
@RequestMapping(value = "/helloTest")
public interface Client02 {
    @RequestMapping(value = "/test")
    String test();
}
