package com.hfc.feign;

import com.hfc.config.FeignLevelConfiguration;
import com.hfc.vo.UserTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangfeichang.
 * @date 2019/8/22 0022.
 */
@FeignClient(name = "client02", configuration = FeignLevelConfiguration.class)
@RequestMapping(value = "/helloTest")
public interface Client02 {
    @RequestMapping(value = "/testGet")
    String testGet(@RequestParam("name") String name);

    @RequestMapping(value = "/testPost")
    String testPost(@RequestBody UserTest userTest);
}
