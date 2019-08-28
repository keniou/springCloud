package com.hfc.controller;

import com.hfc.feign.Client02;
import com.hfc.vo.UserTest;
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

    @RequestMapping(value = "/testGet")
    public String testGet() {
        System.err.println("1");
        String r = client02.testGet("xxxxx");
        System.err.println(r);
        return "ok";
    }

    @RequestMapping(value = "/testPost")
    public String testPost() {
        System.err.println("1");
        UserTest userTest = new UserTest();
        userTest.setName("yyyyyy");
        String r = client02.testPost(userTest);
        System.err.println(r);
        return "ok";
    }
}
