package com.cashsystem.cmd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname CustomerCommand
 * @Description TODO
 * @Date 2019/8/4 12:03
 * @Created by AppleTree
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomerCommand {
}
