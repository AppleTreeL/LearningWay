package com.cashsystem.cmd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname AdminCommand
 * @Description TODO
 * @Date 2019/8/4 12:03
 * @Created by AppleTree
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//表示作用在类上
public @interface AdminCommand {
}
