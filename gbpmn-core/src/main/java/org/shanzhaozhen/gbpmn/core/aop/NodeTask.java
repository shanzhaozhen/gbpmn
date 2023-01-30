package org.shanzhaozhen.gbpmn.core.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-30
 * @Description:
 */
@Target(ElementType.METHOD)  // 该注解可以作用于那些类型元素上：类、方法、字段
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
public @interface NodeTask {

    /**
     * 操作类型
     * @return
     */
    String type() default "1";

    /**
     * 模块
     * @return
     */
    String module() default "";

    /**
     * 名称参数
     * @return
     */
    String name() default "name";

}
