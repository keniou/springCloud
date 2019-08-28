package com.hfc.controller;

import com.hfc.feign.Client02;
import com.hfc.vo.UserTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangfeichang.
 * @date 2019/8/22 0022.
 */
@RestController
@RequestMapping(value = "/helloTest")
@Slf4j
public class HelloTest implements Client02 {

    @Override
    public String testGet(String name) {
        log.info("请求成功get");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("hello............." + name);
        return "ok";
    }

    @Override
    public String testPost(UserTest userTest) {
        log.info("请求成功post");
        System.err.println("hello............." + userTest.getName());
        return "ok";
    }
}
