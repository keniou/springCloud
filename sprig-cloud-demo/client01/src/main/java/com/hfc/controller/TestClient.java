package com.hfc.controller;

import com.hfc.feign.Client02;
import com.hfc.vo.UserTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author huangfeichang.
 * @date 2019/8/22 0022.
 */
@RestController
@RequestMapping(value = "/testClient")
public class TestClient {
    private static Logger logger = LoggerFactory.getLogger(TestClient.class);

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
        userTest.setAge("12333");
        userTest.setList(new ArrayList<String>(){
            {
                add("1");add("2");
            }
        });
        String r = client02.testPost(userTest);
        System.err.println(r);
        return "ok";
    }

    @RequestMapping(value = "/zuulTest/{name}")
    public String zuulTest(@PathVariable("name") String name) {
        logger.info("my name  is {}", name);
        return name;
    }
}
