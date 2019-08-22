package com.hfc.controller;

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
public class HelloTest {


    @RequestMapping(value = "/test")
    public String test() {
        log.info("请求成功");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("hello.............");
        return "ok";
    }
}
