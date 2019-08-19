package com.hfc.system;

import com.alibaba.fastjson.JSON;
import com.hfc.annotion.EnableUserClient;
import com.hfc.config.UserConfigure;
import com.hfc.config.UserProperties;
import com.hfc.core.UserClient;
import com.hfc.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@SpringBootApplication
@EnableUserClient
@Import({UserConfigure.class})
public class BootTestApplication {

    @Autowired
    private UserClient userClient;

    @Autowired
    private Environment environment;

    @Autowired
    private UserProperties userProperties;

    @Autowired(required = false)
    @Qualifier
    private List<User> list = Collections.emptyList();

    @Autowired(required = false)
    @Qualifier
    private Map<String, User> map = new HashMap<>();

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(BootTestApplication.class, args);
    }

    @PostConstruct
    public void test() {
        System.err.println(JSON.toJSONString(list));
        System.err.println(map);
    }
}
