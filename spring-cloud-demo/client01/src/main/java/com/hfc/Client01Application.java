package com.hfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Client01Application {
    public static void main(String[] args) {
        SpringApplication.run(Client01Application.class, args);
    }
}
