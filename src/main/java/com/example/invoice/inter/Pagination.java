package com.example.invoice.inter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Pagination
 * @Description TODO
 * @Date 2022/3/28 15:19
 * @Author by fuxf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pagination {
    // 第几页的请求参数名称 通过获取参数名称获取真正的pageNo
    String pageNo() default "pageNo";

    // 分页大小的请求参数名称
    String pageSize() default "pageSize";

}
