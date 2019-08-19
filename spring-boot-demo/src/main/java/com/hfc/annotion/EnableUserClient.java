package com.hfc.annotion;

import com.hfc.autoconfig.UserAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(UserAutoConfigure.class)
public @interface EnableUserClient {
}
