package com.hfc.controller;

import com.hfc.feign.Client02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangfeichang.
 * @date 2019/8/22 0022.
 */
@RestController
@RequestMapping(value = "/testClient")
public class TestClient {

    @Autowired
    private Client02 client02;

    @RequestMapping(value = "/test")
    public String test() {
        System.err.println("1");
        String r = client02.test();
        System.err.println(r);
        return "ok";
    }
}
