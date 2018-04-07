package com.xujun.ssh.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 权限注解  用于方法和类上面
 * @author Administrator
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permissions {
	Permission value() default Permission.NONE;
}
