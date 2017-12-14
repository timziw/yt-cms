package com.yh.cms.support.fastjson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义 json 过滤注解 liuyt 2017年4月11日 下午1:30:18
 */
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface JSON {

	Class<?> type() default Class.class;

	String include() default "";

	String filter() default "";
}
