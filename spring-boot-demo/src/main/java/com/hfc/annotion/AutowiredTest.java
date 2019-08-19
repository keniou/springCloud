package com.hfc.annotion;

import com.hfc.autoconfig.UserAutoConfigure;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author huangfeichang.
 * @date 2019/8/15 0015.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface AutowiredTest {
}
