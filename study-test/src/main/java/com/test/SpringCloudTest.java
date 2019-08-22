package com.test;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import feign.Retryer;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.util.List;

/**
 * @author huangfeichang.
 * @date 2019/8/14 0014.
 */
public class SpringCloudTest {
    public void mm() {

    }
}

@Component
@Data
@ConfigurationProperties(prefix = "spring.user")
class UserProperties {
    private String name;
}


class UserClient {
    private UserProperties userProperties;

    public UserClient() {
    }

    public UserClient(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public String getName() {
        return userProperties.getName();
    }
}

@Configuration
@EnableConfigurationProperties(UserProperties.class)
class UserAutoConfigure {

    @Bean
    @ConditionalOnProperty(prefix = "spring.user", value = "enable", havingValue = "true")
    public UserClient userClient(UserProperties userProperties) {
        return new UserClient(userProperties);
    }
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(UserAutoConfigure.class)
@interface EnableUserClient {

}

class MyRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    @Override
    public Server choose(Object o) {
        // 所有服务
        List<Server> list = iLoadBalancer.getAllServers();
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return iLoadBalancer;
    }
}

@Configuration
class BeanConfiguration {

    @Bean
    public MyRule myRule() {
        return new MyRule();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(5000, 5000, 4);
    }
}

/**
 * xxxx是调用的服务名称
 */
@RibbonClient(name = "xxxx", configuration = BeanConfiguration.class)
class RibbonClientConfig {

}




