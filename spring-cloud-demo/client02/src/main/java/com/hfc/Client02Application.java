package com.hfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@SpringBootApplication
@EnableEurekaClient
public class Client02Application {
    public static void main(String[] args) {
        SpringApplication.run(Client02Application.class, args);
    }
}
